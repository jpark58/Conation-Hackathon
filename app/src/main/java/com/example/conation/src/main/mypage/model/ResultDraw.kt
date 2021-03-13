package com.example.conation.src.main.mypage.model

import com.google.gson.annotations.SerializedName

data class ResultDraw(@SerializedName("drawResult") val drawResult: String,
                      @SerializedName("remainingPoint") val remainingPoint: Int
                      )
