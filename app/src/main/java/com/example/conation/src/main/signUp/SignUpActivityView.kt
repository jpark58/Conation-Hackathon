package com.example.conation.src.main.signUp

import com.example.conation.config.BaseResponse

interface SignUpActivityView {
    fun onPostSignUpSuccess(response: BaseResponse)
    fun onPostSignUpFailure(message: String)
}