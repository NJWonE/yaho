package com.noh.yaho.member.command.domain.service;

import com.noh.yaho.member.command.application.dto.CheckFaceResultDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

public interface MemberAiConnectionService {
    public CheckFaceResultDTO request(MultiValueMap<String, Object> body, String aiURL);
}
