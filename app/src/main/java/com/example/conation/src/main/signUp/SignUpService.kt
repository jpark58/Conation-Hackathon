package com.example.conation.src.main.signUp

import com.example.conation.config.ApplicationClass
import com.example.conation.config.BaseResponse
import com.example.conation.src.main.signUp.model.UserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val view: SignUpActivityView) {

    fun tryPostSignUp(userRequest: UserRequest){
        val retrofit = ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
        retrofit.postSignUp(userRequest).enqueue(object: Callback<BaseResponse>{
            override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                view.onPostSignUpSuccess(response.body() as BaseResponse)
            }

            override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                view.onPostSignUpFailure(t.message ?: "통신 오류")
            }

        }
        )
    }
}