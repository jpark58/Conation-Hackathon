package com.example.conation.src.main.login

import com.example.conation.src.main.login.model.LoginResponse
import com.example.conation.src.main.login.model.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("signIn")
    fun postLogin(@Body params: PostLoginRequest): Call<LoginResponse>
}