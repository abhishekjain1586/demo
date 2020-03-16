package com.example.abhishekjain.mvvmdemo.service;

import com.example.abhishekjain.mvvmdemo.model.response.ResUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIClient {

    @GET("/api/users")
    Call<ResUsers> getUsers(@Query("page") int pageNo, @Query("per_page") int per_page);

}
