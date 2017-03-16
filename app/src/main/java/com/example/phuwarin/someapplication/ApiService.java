package com.example.phuwarin.someapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Phuwarin on 3/8/2017.
 */

public interface ApiService {
    @GET("retrieve.php")
    Call<List<Member>> retrieveMember();

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseModel> registerMember(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password);
}
