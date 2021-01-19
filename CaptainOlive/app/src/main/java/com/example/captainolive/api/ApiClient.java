package com.example.captainolive.api;

import com.example.captainolive.response.ResponseMeal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("/api/json/v1/1/search.php")
    Call<ResponseMeal> responseMeal(@Query("s") String responseMeal);

}
