package com.achihoang.model;

import org.springframework.web.multipart.MultipartFile;

public class PostViFileUpload extends PostVi {
    private MultipartFile multipartFileVi;

    public MultipartFile getMultipartFileVi() {
        return multipartFileVi;
    }

    public void setMultipartFileVi(MultipartFile multipartFileVi) {
        this.multipartFileVi = multipartFileVi;
    }
}
