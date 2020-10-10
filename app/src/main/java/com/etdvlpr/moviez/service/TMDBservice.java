package com.etdvlpr.moviez.service;

import com.etdvlpr.moviez.model.TMDBResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TMDBservice {
    @GET("movie/{type}?api_key={api_key}&language=en-US")
    Call<TMDBResponce> getMovieList(@Path("api_key") String api_key, @Path("type") String type);
}
