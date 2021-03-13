package com.example.conation.src.main.home.model.price

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.conation.R
import com.example.conation.src.main.home.model.Dummy
import com.example.conation.src.main.home.model.recommend.RecommendRVHolder

class PriceRVAdapter: RecyclerView.Adapter<PriceRVHolder>() {
    private var dataList  = ArrayList<Dummy>()
    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceRVHolder {
        return PriceRVHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_rv_item, parent,false))
    }

    override fun onBindViewHolder(holder: PriceRVHolder, position: Int) {
        holder.bindWithView(dataList[position])
        holder.itemView.setOnClickListener {
            listener!!.onClicked(dataList[position])
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun submitList(list: ArrayList<Dummy>){
        this.dataList = list
    }

    fun setOnClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    interface OnItemClickListener{
        fun onClicked(data: Dummy)
    }
}