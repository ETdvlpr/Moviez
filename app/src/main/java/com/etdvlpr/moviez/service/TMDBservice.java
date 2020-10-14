package com.etdvlpr.moviez.service;

import com.etdvlpr.moviez.model.TMDBResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDBservice {
    @GET("movie/{type}?language=en-US")
    Call<TMDBResponce> getMovieList(@Path("type") String type, @Query("api_key") String api_key);
}
