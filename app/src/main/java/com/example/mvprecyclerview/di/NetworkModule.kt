package com.example.mvprecyclerview.di

import com.example.mvprecyclerview.MainActivity
import com.example.mvprecyclerview.MainActivityContract
import com.example.mvprecyclerview.api.ApiInterface
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
@Provides
@Singleton
fun provideRetrofitApi():ApiInterface{
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiInterface.BaseURL)
        .build()
        .create(ApiInterface::class.java)
}

 @Singleton
 @Provides
 fun provideOkhttpCilent(interceptor: HttpLoggingInterceptor):OkHttpClient
     = OkHttpClient().newBuilder()
         .addInterceptor(interceptor)
         .build()

    @Singleton
    @Provides
   fun provideHttpLoggingInterceptor():HttpLoggingInterceptor{
       val loggingInterceptor=HttpLoggingInterceptor()
       loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
           return loggingInterceptor
   }
}