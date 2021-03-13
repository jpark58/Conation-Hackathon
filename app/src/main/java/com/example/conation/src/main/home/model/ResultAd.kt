package com.example.conation.src.main.home.model

import com.google.gson.annotations.SerializedName

data class ResultAd(@SerializedName("advertisementId") val advertisementId: Int,
                    @SerializedName("advertisementName") val advertisementName: String,
                    @SerializedName("minutes") val minutes: Int,
                    @SerializedName("price") val price: Int,
                    @SerializedName("seconds") val seconds: Int,
                    @SerializedName("url") val url: String,
                    @SerializedName("viewCount") val viewCount: Int
)
