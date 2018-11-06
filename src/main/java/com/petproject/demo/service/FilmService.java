package com.petproject.demo.service;

import com.petproject.demo.api.MovieApiResult;
import com.petproject.demo.api.TrailerResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmService {

    @GET("now_playing")
    Call<MovieApiResult> getFilms(@Query("api_key") String apikey, @Query("page") int page, @Query("region") String region);

    @GET("{id}/videos")
    Call<TrailerResult> getVideoKey(@Path("id") String id, @Query("api_key") String apikey);

}
