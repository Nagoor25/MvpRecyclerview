package com.example.mvprecyclerview.api

import android.provider.Settings.Secure.getString
import com.example.mvprecyclerview.R
import com.example.mvprecyclerview.model.ServerResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    /* https://api.themoviedb.org/3/movie/top_rated?api_key=11f9c45d0a1f3b2e8ef6b132e83dd063&language=en-US&page=1 */
companion object{
        val BaseURL="https://api.themoviedb.org/3/movie/"
        val ImageBaseURL= "https://image.tmdb.org/t/p/w500/"
        val api_key="11f9c45d0a1f3b2e8ef6b132e83dd063"
    }

    @GET("top_rated")
     fun getTopRatedMovies(
    @Query("api_key")
    apiKey :String= api_key,
    @Query("language")
    language: String="en-US",
    @Query("page")
    page:String="1"
    ):Call<ServerResponse>

}