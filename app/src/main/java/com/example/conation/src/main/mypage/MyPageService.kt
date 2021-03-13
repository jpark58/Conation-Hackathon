package com.example.conation.src.main.mypage

import com.example.conation.config.ApplicationClass
import com.example.conation.src.main.mypage.model.DrawResponse
import com.example.conation.src.main.mypage.model.MyPageResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val view: MyPageFragmentView) {

    fun tryPostMyPage(){
        val retrofit = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        retrofit.postUserInfo().enqueue(object: Callback<MyPageResponse>{
            override fun onResponse(
                call: Call<MyPageResponse>,
                response: Response<MyPageResponse>
            ) {
                view.onPostMyPageSuccess(response.body() as MyPageResponse)
            }

            override fun onFailure(call: Call<MyPageResponse>, t: Throwable) {
                view.onPostMyPageFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun tryGetDraw(){
        val retrofit = ApplicationClass.sRetrofit.create(MyPageRetrofitInterface::class.java)
        retrofit.getRandomDraw().enqueue(object: Callback<DrawResponse>{
            override fun onResponse(call: Call<DrawResponse>, response: Response<DrawResponse>) {
                view.onGetDrawSuccess(response.body() as DrawResponse)
            }

            override fun onFailure(call: Call<DrawResponse>, t: Throwable) {
                view.onGetDrawFailure(t.message ?: "통신 오류")
            }

        })
    }
}