package com.example.conation.src.main.login.model

import com.google.gson.annotations.SerializedName

data class PostLoginRequest(@SerializedName("password") val password: String, @SerializedName("userId") val userId: String)
