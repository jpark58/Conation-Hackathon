package com.example.conation.src.main.chart

import com.example.conation.src.main.chart.model.DonationResponse

interface DonationFragmentView {
    fun onGetDonationSuccess(response: DonationResponse)
    fun onGetDonationFailure(message: String)
}