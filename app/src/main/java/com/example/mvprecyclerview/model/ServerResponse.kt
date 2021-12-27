package com.example.mvprecyclerview.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ServerResponse(
    val page: Int,
    val results: ArrayList<Result>,
    val total_pages: Int,
    val total_results: Int
): Parcelable

/*  @SerializedName("results")
    val results: ArrayList<Movies>,*/