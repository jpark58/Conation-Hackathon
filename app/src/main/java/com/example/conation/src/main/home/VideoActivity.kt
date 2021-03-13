package com.example.conation.src.main.home

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.conation.config.BaseActivity
import com.example.conation.databinding.ActivityVideoBinding
import com.example.conation.src.main.home.model.Dummy
import com.example.conation.src.main.home.model.Recast
import com.example.conation.src.main.home.model.ResultAd
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory

class VideoActivity : BaseActivity<ActivityVideoBinding>(ActivityVideoBinding::inflate) {

    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var uri: Uri
    private lateinit var data: Recast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        data = intent.getSerializableExtra("data") as Recast

        uri = Uri.parse(data.url)
        binding.videoTitle.text = data.title
        binding.videoPoints.text = "%,d".format(data.price) + "p"
        binding.videoViews.text = "%,d".format(data.viewCount) + " views"
    }


    override fun onStart() {
        super.onStart()

        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this, DefaultTrackSelector())
        binding.videoPlayerview.player = simpleExoPlayer
        var factory: DataSource.Factory = DefaultDataSourceFactory(this, "conation")
        var mediaSource: ProgressiveMediaSource = ProgressiveMediaSource.Factory(factory).createMediaSource(uri)
        simpleExoPlayer.prepare(mediaSource)
        simpleExoPlayer.playWhenReady = true

    }

    override fun onStop() {
        super.onStop()
        binding.videoPlayerview.player = null
        simpleExoPlayer.release()
    }
}