package com.example.mvprecyclerview.di

import android.app.Activity
import com.example.mvprecyclerview.MainActivity
import com.example.mvprecyclerview.MainActivityContract
import com.example.mvprecyclerview.MainViewPresenter
import com.example.mvprecyclerview.model.MovieModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    @Binds
    abstract fun bindActivity( activity:MainActivity): MainActivityContract.View
    @Binds
    abstract fun bindPresenter(impl:MainViewPresenter): MainActivityContract.Presenter
    /*@Binds
    abstract fun bindModel(model: MovieModel): MainActivityContract.Model
*/


}
@InstallIn(ActivityComponent::class)
@Module
object MainActivityModule {

    @Provides
    fun bindActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }
}
