package com.example.conation.src.main.home

import com.example.conation.config.ApplicationClass
import com.example.conation.src.main.home.model.AdResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecommendService(val view: RecommendView) {

    fun tryGetAds(category: String? = null, orderType: String, page: Int){
        val retrofit = ApplicationClass.sRetrofit.create(RecommendRetrofitInterface::class.java)
        retrofit.getAds(category, orderType, page).enqueue(object: Callback<AdResponse>{
            override fun onResponse(call: Call<AdResponse>, response: Response<AdResponse>) {
                view.onGetAdSuccess(response.body() as AdResponse)
            }

            override fun onFailure(call: Call<AdResponse>, t: Throwable) {
                view.onGetAdFailure(t.message ?: "통신 오류")
            }

        })
    }
}