package com.noh.yaho.meeting.command.application.service;

import com.noh.yaho.meeting.command.application.dto.ConversationDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingDTO;
import com.noh.yaho.meeting.command.application.dto.MeetingResultDTO;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {
    public List<ConversationDTO> registMeeting(MeetingDTO meetingDTO) {
        List<ConversationDTO> conversationDTOList = meetingDTO.getConversation();
        conversationDTOList.sort(new Comparator<ConversationDTO>() {
            @Override
            public int compare(ConversationDTO o1, ConversationDTO o2) {
                if(o1.getTime().getTime()-o2.getTime().getTime()>1){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, List<ConversationDTO>> body = new LinkedMultiValueMap<>();
        body.add("conversation", conversationDTOList);
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
        MeetingResultDTO response = restTemplate.postForObject("asdasdasd", requestMessage, MeetingResultDTO.class);

        return conversationDTOList;
    }
}
