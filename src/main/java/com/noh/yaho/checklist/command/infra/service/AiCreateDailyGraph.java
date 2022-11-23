package com.noh.yaho.checklist.command.infra.service;

import com.noh.yaho.checklist.command.application.dto.imageUrlDTO;
import com.noh.yaho.checklist.command.domain.service.AiConnectionCheckService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AiCreateDailyGraph implements AiConnectionCheckService {

    @Override
    public imageUrlDTO createDailyGraph(MultiValueMap<String, Integer> body, String aiURL){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        CloseableHttpClient client = HttpClientBuilder.create().setMaxConnTotal(100).setMaxConnPerRoute(5).build();
        factory.setHttpClient(client);

        RestTemplate restTemplate = new RestTemplate(factory);

        imageUrlDTO response = restTemplate.postForObject(aiURL, requestMessage, imageUrlDTO.class);

        return response;
    }
}
