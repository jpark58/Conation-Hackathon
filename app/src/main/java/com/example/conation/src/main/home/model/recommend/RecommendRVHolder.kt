package com.example.conation.src.main.home.model.recommend

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conation.R
import com.example.conation.src.main.home.model.ResultAd
import kotlinx.android.synthetic.main.video_rv_item.view.*

class RecommendRVHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val thumbnail = itemView.video_rv_thumbnail
    private val views = itemView.video_rv_views
    private val title = itemView.video_rv_title
    private val points = itemView.video_rv_points

    fun bindWithView(item: ResultAd){
        if(item.advertisementName.length % 2 == 0){
            Glide.with(itemView).load("dummy").placeholder(R.drawable.thumbnail).into(thumbnail)
        }else{
            Glide.with(itemView).load("dummy").placeholder(R.drawable.thumbnail2).into(thumbnail)
        }

        views.text = "%,d".format(item.viewCount) + " views"
        title.text = item.advertisementName
        points.text = "%,d".format(item.price) + "p"
    }
}