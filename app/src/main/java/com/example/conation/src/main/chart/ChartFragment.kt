package com.example.conation.src.main.chart

import android.os.Bundle
import android.view.View
import com.example.conation.R
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentChartBinding
import com.example.conation.src.main.chart.model.DonationResponse

class ChartFragment :BaseFragment<FragmentChartBinding>(FragmentChartBinding::bind, R.layout.fragment_chart), DonationFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DonationService(this).tryGetDonations()
    }

    override fun onGetDonationSuccess(response: DonationResponse) {
        when(response.code){
            1000 -> {
                showCustomToast(response.message.toString())
                binding.chartTotalPoint.text = "%,d".format(response.result.totalScore) + "p"
                binding.chartTotalTodayDate.text = response.result.today
                binding.chartTotalTodayPoint.text = "%,d".format(response.result.todayScore)+"p"
            }
            else -> {
                showCustomToast(response.message.toString())
            }
        }
    }

    override fun onGetDonationFailure(message: String) {
        showCustomToast(message)
    }

}