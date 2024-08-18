package com.hackafun.friendy2.service;

import com.hackafun.friendy2.model.MatchingDto;
import com.hackafun.friendy2.model.MatchingRequestDto;
import com.hackafun.friendy2.model.ScanFaceDto;
import com.hackafun.friendy2.model.ScanFaceRequestDto;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Body;

public interface ApiService {
    @GET("/matching")
    Call<MatchingDto> getMatch(@Body MatchingRequestDto request);

    @Multipart
    @POST("/scan_face")
    Call<ScanFaceDto> getGeneratedAvatar(
            @Part MultipartBody.Part image
    );
}
