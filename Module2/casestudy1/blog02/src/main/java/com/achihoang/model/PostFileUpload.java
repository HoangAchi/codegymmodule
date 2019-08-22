package com.achihoang.model;

import org.springframework.web.multipart.MultipartFile;

public class PostFileUpload extends Post {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
