package com.noh.yaho.checklist.command.domain.service;

import com.noh.yaho.checklist.command.application.dto.imageUrlDTO;
import org.springframework.util.MultiValueMap;

public interface AiConnectionCheckService {
    public imageUrlDTO createDailyGraph(MultiValueMap<String, Integer> body, String aiURL);
}
