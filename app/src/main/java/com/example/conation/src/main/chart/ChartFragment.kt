package com.example.conation.src.main.chart

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conation.R
import com.example.conation.config.ApplicationClass
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentChartBinding
import com.example.conation.src.main.chart.model.ChartData
import com.example.conation.src.main.chart.model.DonationResponse
import com.example.conation.src.main.chart.model.ResultCity

class ChartFragment :BaseFragment<FragmentChartBinding>(FragmentChartBinding::bind, R.layout.fragment_chart), DonationFragmentView {
    private var dataList = ArrayList<ChartData>()
    private lateinit var adapter: ChartRVAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        this.adapter = ChartRVAdapter()
//        this.adapter.submitList(dataList)
//        binding!!.chartRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        binding!!.chartRecyclerview.adapter = this.adapter


        DonationService(this).tryGetDonations()

    }

    override fun onResume() {
        super.onResume()
    }


    override fun onGetDonationSuccess(response: DonationResponse) {
        when(response.code){
            1000 -> {
                showCustomToast(response.message.toString())
                binding.chartTotalPoint.text = "%,d".format(response.result.totalScore) + "p"
                binding.chartTotalTodayDate.text = response.result.today
                binding.chartTotalTodayPoint.text = "%,d".format(response.result.todayScore)+"p"

//                Log.d("로그", response.result.regionDonationsStatuses[0].regionName)
//
//
//                if(response.result.regionDonationsStatuses != null){
//                    this.dataList.clear()
//                    for(i in response.result.regionDonationsStatuses){
//                        val temp = ChartData(i.regionName, i.accumulatedRegionDonationScore)
//                        this.dataList.add(temp)
//                    }
//                    this.adapter.notifyDataSetChanged()
//                }

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