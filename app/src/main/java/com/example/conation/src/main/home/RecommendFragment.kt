package com.example.conation.src.main.home

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conation.R
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentRecommendBinding
import com.example.conation.src.main.home.model.*
import com.example.conation.src.main.home.model.recommend.RecommendRVAdapter
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import java.io.Serializable
import java.sql.Timestamp


class RecommendFragment : BaseFragment<FragmentRecommendBinding>(FragmentRecommendBinding::bind, R.layout.fragment_recommend), RecommendView {


    private var dataList = ArrayList<ResultAd>()
    private lateinit var dataAdapter: RecommendRVAdapter

    private var startstamp = 0L
    private var adId = 1
    private var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.dataAdapter = RecommendRVAdapter()
        this.dataAdapter.submitList(dataList)
        binding.recommendRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recommendRecyclerview.adapter = this.dataAdapter

        dataAdapter.setOnClickListener(onClicked)
        RecommendService(this).tryGetAds(null, "NONE", 1)
    }

    private val onClicked = object: RecommendRVAdapter.OnItemClickListener{
        override fun onClicked(data: ResultAd) {
            startstamp = System.currentTimeMillis()
            val intent = Intent(activity, VideoActivity::class.java)
            var temp = Recast(data.advertisementId, data.advertisementName, data.price, data.url, data.viewCount)
            adId = data.advertisementId
            price = data.price
            intent.putExtra("data", temp)
            startActivityForResult(intent, 100)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            100 -> {
                val endstamp = System.currentTimeMillis()

                if(endstamp - startstamp >= 13000){
                    val dialog = DonationDialog(true, price)
                    dialog.show(childFragmentManager, dialog.tag)
                    val temp = PatchAdRequest(adId)
                    RecommendService(this).tryPatchAdsCount(temp)
                }else{
                    val dialog = DonationDialog(false, price)
                    dialog.show(childFragmentManager, dialog.tag)
                }
            }
        }
    }

    override fun onGetAdSuccess(response: AdResponse) {
        when(response.code){
            1000 -> {
                showCustomToast(response.message.toString())
                this.dataList.clear()
                this.dataList.addAll(response.result as ArrayList<ResultAd>)
                this.dataAdapter.notifyDataSetChanged()
            }
            else -> {
                showCustomToast(response.message.toString())
            }
        }
    }

    override fun onGetAdFailure(message: String) {
        showCustomToast(message)
    }

    override fun onPatchAdCountSuccess(response: AdCountResponse) {
        showCustomToast(response.message.toString())
    }

    override fun onPatchAdCountFailure(message: String) {
        showCustomToast(message)
    }

}


