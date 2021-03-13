package com.example.conation.src.main.mypage

import com.example.conation.src.main.mypage.model.DrawResponse
import com.example.conation.src.main.mypage.model.MyPageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface MyPageRetrofitInterface {
    @POST("/mypage")
    fun postUserInfo(): Call<MyPageResponse>

    @GET("/randomdraw")
    fun getRandomDraw(): Call<DrawResponse>
}