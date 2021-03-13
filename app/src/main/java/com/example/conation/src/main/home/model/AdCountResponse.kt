package com.example.conation.src.main.home.model

import com.example.conation.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class AdCountResponse(@SerializedName("result") val result: Int): BaseResponse()
