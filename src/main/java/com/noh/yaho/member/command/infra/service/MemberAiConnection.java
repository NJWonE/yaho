package com.noh.yaho.member.command.infra.service;

import com.noh.yaho.member.command.application.dto.CheckFaceResultDTO;
import com.noh.yaho.member.command.domain.service.MemberAiConnectionService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class MemberAiConnection implements MemberAiConnectionService {
    @Override
    public CheckFaceResultDTO request(MultiValueMap<String, Object> body, String aiURL) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        CloseableHttpClient client = HttpClientBuilder.create().setMaxConnTotal(100).setMaxConnPerRoute(5).build();
        factory.setHttpClient(client);

        RestTemplate restTemplate = new RestTemplate(factory);

        CheckFaceResultDTO response = restTemplate.postForObject(aiURL, body, CheckFaceResultDTO.class);
        return response;
    }
}
