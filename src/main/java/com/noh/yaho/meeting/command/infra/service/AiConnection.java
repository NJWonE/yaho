package com.noh.yaho.meeting.command.infra.service;

import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingResultDTO;
import com.noh.yaho.meeting.command.domain.service.AiConnectionService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class AiConnection implements AiConnectionService {

    @Override
    public MeetingResultDTO request(MultiValueMap<String, List<ConversationDTO>> body, String aiURL){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(5)
                .build();
        factory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(factory);
        MeetingResultDTO response = restTemplate.postForObject(aiURL, requestMessage, MeetingResultDTO.class);

        return response;
    }
}
