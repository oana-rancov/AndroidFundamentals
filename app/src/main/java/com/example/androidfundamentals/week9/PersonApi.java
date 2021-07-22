package com.example.androidfundamentals.week9;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {
    @GET("/oana-rancov/AndroidFundamentals/Styles/{filename}")
    Call<List<Person>> getPersons(@Path("filename") String jsonToFetch);
}
