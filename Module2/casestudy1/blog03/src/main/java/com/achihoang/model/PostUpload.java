package com.achihoang.model;

import org.springframework.web.multipart.MultipartFile;

public class PostUpload extends Post {
    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
