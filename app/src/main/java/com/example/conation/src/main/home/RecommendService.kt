package com.example.conation.src.main.home

import com.example.conation.config.ApplicationClass
import com.example.conation.src.main.home.model.AdCountResponse
import com.example.conation.src.main.home.model.AdResponse
import com.example.conation.src.main.home.model.PatchAdRequest
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

    fun tryPatchAdsCount(patchAdRequest: PatchAdRequest){
        val retrofitInterface = ApplicationClass.sRetrofit.create(RecommendRetrofitInterface::class.java)
        retrofitInterface.postAdCount(patchAdRequest).enqueue(object: Callback<AdCountResponse>{
            override fun onResponse(
                call: Call<AdCountResponse>,
                response: Response<AdCountResponse>
            ) {
                view.onPatchAdCountSuccess(response.body() as AdCountResponse)
            }

            override fun onFailure(call: Call<AdCountResponse>, t: Throwable) {
                view.onPatchAdCountFailure(t.message ?: "통신 오류")
            }

        })
    }
}