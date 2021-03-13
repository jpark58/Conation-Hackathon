package com.example.conation.src.main.home

import com.example.conation.src.main.home.model.AdCountResponse
import com.example.conation.src.main.home.model.AdResponse
import com.example.conation.src.main.home.model.PatchAdRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Query

interface RecommendRetrofitInterface {

    @GET("/advertisements")
    fun getAds(@Query("category") category: String? = null, @Query("orderType") orderType: String, @Query("page") page:Int): Call<AdResponse>

    @PATCH("/view-advertisements")
    fun postAdCount(@Body params: PatchAdRequest): Call<AdCountResponse>
}