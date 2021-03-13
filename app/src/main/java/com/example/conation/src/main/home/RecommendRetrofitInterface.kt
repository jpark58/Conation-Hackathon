package com.example.conation.src.main.home

import com.example.conation.src.main.home.model.AdResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RecommendRetrofitInterface {

    @GET("/advertisements")
    fun getAds(@Query("category") category: String? = null, @Query("orderType") orderType: String, @Query("page") page:Int): Call<AdResponse>
}