package com.example.conation.src.main.chart.model

import com.google.gson.annotations.SerializedName

data class ResultCity(@SerializedName("accumulatedRegionDonationScore") val regionScore: Int,
                      @SerializedName("regionName") val regionName: String
                    )
