package com.example.conation.src.main.mypage

import com.example.conation.src.main.mypage.model.DrawResponse
import com.example.conation.src.main.mypage.model.MyPageResponse

interface MyPageFragmentView {
    fun onPostMyPageSuccess(response: MyPageResponse)
    fun onPostMyPageFailure(message: String)

    fun onGetDrawSuccess(response: DrawResponse)
    fun onGetDrawFailure(message: String)
}