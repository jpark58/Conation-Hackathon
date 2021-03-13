package com.example.conation.src.main.chart

import com.example.conation.src.main.chart.model.DonationResponse
import retrofit2.Call
import retrofit2.http.GET

interface DonationRetrofitInterface {

    @GET("/donation-status")
    fun getDonations(): Call<DonationResponse>
}