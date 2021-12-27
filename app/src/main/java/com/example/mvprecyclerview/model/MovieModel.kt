package com.example.mvprecyclerview.model

import com.example.mvprecyclerview.MainActivityContract
import com.example.mvprecyclerview.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieModel : MainActivityContract.Model {
    override fun getTopMovies(listener: MainActivityContract.ApiListener) {

        try {
            val response = RetrofitInstance.api.getTopRatedMovies()

            response.enqueue(object : Callback<ServerResponse> {
                override fun onResponse(
                    call: Call<ServerResponse>,
                    response: Response<ServerResponse>
                ) {
                   if (response.isSuccessful) {
                       listener.onSuccess(response)
                   }else{
                       listener.onError(response)
                   }
                }

                override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                    listener.onFailure(t)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}