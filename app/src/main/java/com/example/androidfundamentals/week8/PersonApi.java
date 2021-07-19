package com.example.androidfundamentals.week8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {
    //base_url, iar apoi api si doar aia punem
    @GET("/oana-rancov/AndroidFundamentals/Styles/{filename}")
    Call<List<User>> getPersons(@Path("filename") String jsonToFetch);
}
