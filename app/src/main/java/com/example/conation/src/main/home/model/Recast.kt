package com.example.conation.src.main.home.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Recast(val adId: Int, val title: String, val price: Int, val url: String, val viewCount: Int): Serializable
