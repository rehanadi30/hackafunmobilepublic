package com.hackafun.friendy2.model;

import okhttp3.MultipartBody;

public class ScanFaceRequestDto {
    private final MultipartBody.Part image;

    public ScanFaceRequestDto(MultipartBody.Part image) {
        this.image = image;
    }

    public MultipartBody.Part getImage() {
        return image;
    }
}
