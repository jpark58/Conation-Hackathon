package com.example.conation.src.main.home

import com.example.conation.src.main.home.model.AdCountResponse
import com.example.conation.src.main.home.model.AdResponse

interface RecommendView {
    fun onGetAdSuccess(response: AdResponse)
    fun onGetAdFailure(message: String)

    fun onPatchAdCountSuccess(response: AdCountResponse)
    fun onPatchAdCountFailure(message: String)
}