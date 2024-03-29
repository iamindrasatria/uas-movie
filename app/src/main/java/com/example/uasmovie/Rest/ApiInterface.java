package com.example.uasmovie.Rest;

import com.example.uasmovie.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET ("/3/movie/{category}")
    Call<Response>getMovie(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("Page") int page
    );
}
