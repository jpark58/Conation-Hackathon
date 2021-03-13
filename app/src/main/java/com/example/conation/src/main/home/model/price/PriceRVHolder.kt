package com.example.conation.src.main.home.model.price

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conation.R
import com.example.conation.src.main.home.model.Dummy
import kotlinx.android.synthetic.main.video_rv_item.view.*

class PriceRVHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val thumbnail = itemView.video_rv_thumbnail
    private val views = itemView.video_rv_views
    private val title = itemView.video_rv_title
    private val points = itemView.video_rv_points

    fun bindWithView(item: Dummy){
        Glide.with(itemView).load(item.img).placeholder(R.drawable.thumbnail).into(thumbnail)
        views.text = item.views
        title.text = item.title
        points.text = item.points
    }
}