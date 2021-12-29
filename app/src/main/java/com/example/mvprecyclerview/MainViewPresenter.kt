package com.example.mvprecyclerview

import android.util.Log
import com.example.mvprecyclerview.model.MovieModel
import com.example.mvprecyclerview.model.ServerResponse
import retrofit2.Response
import javax.inject.Inject


class MainViewPresenter @Inject constructor(private val view: MainActivityContract.View    ):
    MainActivityContract.Presenter,MainActivityContract.ApiListener{

     var mModel: MainActivityContract.Model

    init {
       mModel=MovieModel()
        view.uiSetup()
        //Api call
        getTopMovies()
  }
    override fun getTopMovies() {
        view.showProgressDialog()
        mModel.getTopMovies(this)
    }

    override fun onSuccess(response: Response<ServerResponse>?) {
        view.hideProgressDialog()
        response?.body().let {
            Log.d("mvp onSuccess", it?.results.toString())
            it?.let { it1 -> view.displayMovieData(it1.results) }
        }

    }

    override fun onError(response: Response<ServerResponse>?) {
      view.hideProgressDialog()
        view.showMessage("Error occured")
    }

    override fun onFailure(t: Throwable?) {
        view.hideProgressDialog()
        t?.message?.let { view.showMessage(it) }
    }
}