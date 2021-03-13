package com.example.conation.src.main.home.model

import com.example.conation.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class AdResponse(@SerializedName("result") val result: ArrayList<ResultAd>):BaseResponse()
