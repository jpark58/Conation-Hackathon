package com.example.conation.src.main.home.model.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.conation.R
import com.example.conation.src.main.home.model.AdResponse
import com.example.conation.src.main.home.model.Dummy
import com.example.conation.src.main.home.model.ResultAd

class RecommendRVAdapter: RecyclerView.Adapter<RecommendRVHolder>() {
    private var dataList  = ArrayList<ResultAd>()
    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendRVHolder {
        return RecommendRVHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_rv_item, parent,false))
    }

    override fun onBindViewHolder(holder: RecommendRVHolder, position: Int) {
        holder.bindWithView(dataList[position])
        holder.itemView.setOnClickListener {
            listener!!.onClicked(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun submitList(list: ArrayList<ResultAd>){
        this.dataList = list
    }

    fun setOnClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    interface OnItemClickListener{
        fun onClicked(data: ResultAd)
    }
}