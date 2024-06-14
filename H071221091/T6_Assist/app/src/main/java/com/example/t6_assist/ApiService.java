package com.example.t6_assist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/users")
    Call<UserResponse> getUsers(@Query("page") int page);
    @GET("api/users/{id}")
    Call<UserDetailResponse> getUserDetails(@Path("id") int userId);
}

//DISINI PALING PENTING JIKA INGIN MNGATUR BERAPA YANG MAU DITAMPILKAN