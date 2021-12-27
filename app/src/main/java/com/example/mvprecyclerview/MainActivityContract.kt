package com.example.mvprecyclerview

import com.example.mvprecyclerview.model.Result
import com.example.mvprecyclerview.model.ServerResponse
import retrofit2.Response

interface MainActivityContract {
    interface Model{
        fun getTopMovies(listener:ApiListener)
    }
    interface View{
        fun uiSetup()
        fun showMessage(message:String)
        fun showProgressDialog()
        fun hideProgressDialog()
        fun displayMovieData(list:ArrayList<Result>)
    }
    interface  Presenter{
     fun  getTopMovies()
    }
    interface ApiListener{

        fun onSuccess(response: Response<ServerResponse>?)
        fun onError(response: Response<ServerResponse>?)
        fun onFailure(t: Throwable?)
    }
}