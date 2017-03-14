package com.example.phuwarin.someapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Phuwarin on 3/8/2017.
 */

public interface ApiService {
    @GET("retrieve.php")
    Call<List<Member>> retrieveMember();
 }
