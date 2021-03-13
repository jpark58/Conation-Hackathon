package com.example.conation.src.main.mypage.model

import com.example.conation.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class DrawResponse(@SerializedName("result") val result: ResultDraw): BaseResponse()
