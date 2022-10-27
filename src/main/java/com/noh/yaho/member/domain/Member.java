package com.noh.yaho.member.domain;

import com.noh.yaho.member.dto.Authorities;

import java.sql.Date;

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
public class Member {
    private int memberCode;
    private String memberId;
    private String memberPw;
    private java.sql.Date pwChangedDate;
    private java.sql.Date pwExpirationDate;
    private String memberName;
    private String phone;
    private String email;
    private java.sql.Date signupDate;
    private java.sql.Date withdrawalDate;
    private String isWithdrawal;
    private Authorities authorities;

    public Member() {
    }

    public Member(int memberCode, String memberId, String memberPw, Date pwChangedDate, Date pwExpirationDate, String memberName, String phone, String email, Date signupDate, Date withdrawalDate, String isWithdrawal, Authorities authorities) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.pwChangedDate = pwChangedDate;
        this.pwExpirationDate = pwExpirationDate;
        this.memberName = memberName;
        this.phone = phone;
        this.email = email;
        this.signupDate = signupDate;
        this.withdrawalDate = withdrawalDate;
        this.isWithdrawal = isWithdrawal;
        this.authorities = authorities;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public Date getPwChangedDate() {
        return pwChangedDate;
    }

    public void setPwChangedDate(Date pwChangedDate) {
        this.pwChangedDate = pwChangedDate;
    }

    public Date getPwExpirationDate() {
        return pwExpirationDate;
    }

    public void setPwExpirationDate(Date pwExpirationDate) {
        this.pwExpirationDate = pwExpirationDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Date getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(Date withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public String getIsWithdrawal() {
        return isWithdrawal;
    }

    public void setIsWithdrawal(String isWithdrawal) {
        this.isWithdrawal = isWithdrawal;
    }

    public Authorities getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", pwChangedDate=" + pwChangedDate +
                ", pwExpirationDate=" + pwExpirationDate +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", signupDate=" + signupDate +
                ", withdrawalDate=" + withdrawalDate +
                ", isWithdrawal='" + isWithdrawal + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
