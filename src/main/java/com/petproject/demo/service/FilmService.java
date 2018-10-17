package com.petproject.demo.service;

import com.petproject.demo.api.MovieApiResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmService {

    @GET("now_playing")
    Call<MovieApiResult> getFilms(@Query("api_key") String apikey);
}
