package com.achihoang.model;

import org.springframework.web.multipart.MultipartFile;

public class UserFileUpload extends User{
    private MultipartFile fileUser;

    public MultipartFile getFileUser() {
        return fileUser;
    }

    public void setFileUser(MultipartFile fileUser) {
        this.fileUser = fileUser;
    }
}
