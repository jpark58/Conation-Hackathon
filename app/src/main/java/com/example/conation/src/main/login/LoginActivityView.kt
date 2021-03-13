package com.example.conation.src.main.login

import com.example.conation.src.main.login.model.LoginResponse

interface LoginActivityView {

    fun onPostLoginSuccess(response: LoginResponse)
    fun onPostLoginFailure(message: String)
}