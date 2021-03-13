package com.example.conation.src.main.chart

import com.example.conation.config.ApplicationClass
import com.example.conation.src.main.chart.model.DonationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonationService(val view: DonationFragmentView) {
    fun tryGetDonations(){
        val retrofit = ApplicationClass.sRetrofit.create(DonationRetrofitInterface::class.java)
        retrofit.getDonations().enqueue(object: Callback<DonationResponse> {
            override fun onResponse(
                call: Call<DonationResponse>,
                response: Response<DonationResponse>
            ) {
                view.onGetDonationSuccess(response.body() as DonationResponse)
            }

            override fun onFailure(call: Call<DonationResponse>, t: Throwable) {
                view.onGetDonationFailure(t.message ?:"통신 오류")
            }

        })
    }
}