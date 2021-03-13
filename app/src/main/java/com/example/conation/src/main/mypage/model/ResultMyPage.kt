package com.example.conation.src.main.mypage.model

import com.google.gson.annotations.SerializedName

data class ResultMyPage(@SerializedName("id") val id: Int,
                        @SerializedName("myRegion") val myRegion: String,
                        @SerializedName("nickname") val nickname: String,
                        @SerializedName("point") val point: String,
                        @SerializedName("prizeWinRate") val prizeWinRate: Int,
                        @SerializedName("todayPrize") val todayPrize: String
                        )
