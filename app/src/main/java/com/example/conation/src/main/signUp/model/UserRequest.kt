package com.example.conation.src.main.signUp.model

import com.google.gson.annotations.SerializedName

data class UserRequest(@SerializedName("id") val id: String,
                        @SerializedName("nickname") val nickname: String,
                       @SerializedName("password") val password: String,
                       @SerializedName("passwordRepeat") val passwordRepeat: String,
                       @SerializedName("phoneNumber") val phoneNumber: String,
                       @SerializedName("regionId") val regionId: Int
                       )
