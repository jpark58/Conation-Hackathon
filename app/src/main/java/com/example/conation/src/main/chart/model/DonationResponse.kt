package com.example.conation.src.main.chart.model

import com.example.conation.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class DonationResponse(@SerializedName("result") val result: ResultDonation):BaseResponse()
