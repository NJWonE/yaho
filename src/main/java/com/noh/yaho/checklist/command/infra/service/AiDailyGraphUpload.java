package com.noh.yaho.checklist.command.infra.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.noh.yaho.checklist.command.domain.service.CheckAwsSimpleStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AiDailyGraphUpload implements CheckAwsSimpleStorageService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;
    @Override
    public String upload(String base64value) {
        String formatImageValue = base64value.replace("\n", "");
        byte[] byteImage = Base64.getDecoder().decode(formatImageValue.getBytes());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(byteImage.length);

        String fileNameString = String.valueOf(getRandomUuid())+".png";
        amazonS3.putObject(new PutObjectRequest(bucket, fileNameString, new ByteArrayInputStream(byteImage), objectMetadata));

        return amazonS3.getUrl(bucket, fileNameString).toString();
    }
    private static UUID getRandomUuid() {
        return UUID.randomUUID();
    }
}
