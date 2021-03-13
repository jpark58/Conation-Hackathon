package com.example.conation.src.main.login.model

import com.example.conation.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName("result") val result: String): BaseResponse()
