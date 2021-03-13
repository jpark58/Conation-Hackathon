package com.example.conation.src.main.chart.model

import com.google.gson.annotations.SerializedName

data class ResultDonation(@SerializedName("regionDonationsStatuses") val regionDonationsStatuses: ArrayList<ResultCity>,
@SerializedName("today") val today: String,
@SerializedName("todayDonationScore") val todayScore: Int,
@SerializedName("totalDonationScore") val totalScore: Int)
