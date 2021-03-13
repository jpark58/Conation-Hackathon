package com.example.conation.src.main.signUp

import com.example.conation.config.BaseResponse
import com.example.conation.src.main.signUp.model.UserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitInterface {

    @POST("/signUp")
    fun postSignUp(@Body params: UserRequest): Call<BaseResponse>
}