package com.noh.yaho.member.command.application.service;

import com.noh.yaho.member.command.application.dto.CheckFaceDTO;
import com.noh.yaho.member.command.application.dto.CheckFaceResultDTO;
import com.noh.yaho.member.command.application.dto.DetectFaceDTO;
import com.noh.yaho.member.command.domain.model.Face;
import com.noh.yaho.member.command.domain.model.WorkTime;
import com.noh.yaho.member.command.domain.repository.FaceRepository;
import com.noh.yaho.member.command.domain.repository.WorkTimeRepository;
import com.noh.yaho.member.command.domain.service.MemberAiConnectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetectFaceService {
    private final FaceRepository faceRepository;
    private final WorkTimeRepository workTimeRepository;
    private final MemberAiConnectionService memberAiConnectionService;
    @Transactional
    public boolean detectFace(DetectFaceDTO detectFaceDTO, HttpSession httpSession) throws IOException {
        Face findFace = faceRepository.findByMemberNo(detectFaceDTO.getMemberNo()).get();

        List<String> memberFaceList = new ArrayList<>();
        memberFaceList.add(findFace.getFrontFace());
        memberFaceList.add(findFace.getLeftFace());
        memberFaceList.add(findFace.getRightFace());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("detectFace", Base64.getEncoder().encodeToString(detectFaceDTO.getImage().getBytes()));
        body.add("memberFaceList", memberFaceList);

        String aiURL = "http://34.64.121.28:9090/facedetect";

        CheckFaceResultDTO check = memberAiConnectionService.request(body, aiURL);

        if(check.isCheckFace()&&httpSession.getAttribute("workStartTime")==null){
            httpSession.setAttribute("workStartTime", new Date());
        }else if(check.isCheckFace()) {
            WorkTime newWorkTime = new WorkTime(detectFaceDTO.getCommutingManagementNo(), new Date(httpSession.getAttribute("workStartTime").toString()), new Date());
            workTimeRepository.save(newWorkTime);
            httpSession.invalidate();
        }
        return check.isCheckFace();
    }
    @Transactional
    public CheckFaceResultDTO checkFace(CheckFaceDTO checkFaceDTO) throws IOException {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("faceType", checkFaceDTO.getFaceType());
        body.add("image", Base64.getEncoder().encodeToString(checkFaceDTO.getImage().getBytes()));
        String aiURL = "http://34.64.121.28:9090/newface";
        return memberAiConnectionService.request(body, aiURL);
    }
}
