package com.noh.yaho.configuration.jwt;

import com.noh.yaho.configuration.exception.TokenException;
import com.noh.yaho.configuration.jwt.dto.TokenDTO;
import com.noh.yaho.member.command.domain.model.Member;
import com.noh.yaho.member.dto.Authorities;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.*;

/**
 * <pre>
 * Class : Sample
 * Comment : 어떤 클래스인지 간단한 설명
 * History
 * 2022-10-26 노재원 처음 작성
 * </pre>
 *
 * @author 노재원(최초 작성자 명)
 * @version 1.0(클래스의 버전)
 * @see 참고할 class나 외부 url
 */
@Component
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "bearer";
    private static final String MEMBER_NO = "memberNo";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;
    private static Key key;

    private final UserDetailsService userDetailsService;

    TokenProvider(@Value("${jwt.secret}")String secretKey, UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public TokenDTO generateTokenDTO(Member member){
        int memberNo = member.getMemberNo();
        Claims claims = Jwts.claims();
        claims.put(AUTHORITIES_KEY, Authorities.ROLE_USER.name());
        claims.put(MEMBER_NO, memberNo);

        long now = (new Date()).getTime();

        Date accessTokenExpiresIn = new Date(now+ ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder().addClaims(claims)
                .setSubject(member.getMemberId())
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
        return new TokenDTO(BEARER_TYPE, accessToken, accessTokenExpiresIn.getTime());
    }

    public Authentication getAuthentication(String accessToken){
        Claims claims = parseClaims(accessToken);
        if (claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }
//        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getMemberId(accessToken));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw new TokenException("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            throw new TokenException("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            throw new TokenException("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            throw new TokenException("JWT 토큰이 잘못되었습니다.");
        }
    }
    public String getMemberId(String accessToken) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody()
                .getSubject();
    }
    public Claims parseClaims(String accessToken){
        try{
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e){
            return e.getClaims();
        }
    }
}
