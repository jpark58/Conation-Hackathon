package com.example.conation.src.main.chart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.conation.R
import com.example.conation.src.main.chart.model.ChartData
import com.example.conation.src.main.chart.model.ResultCity

class ChartRVAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList = ArrayList<ChartData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chart_rv_non_top_item, parent, false)
                return ChartNonRVHolder(view)
            }
            else ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chart_rv_item, parent,false)
                return ChartTopRVHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ChartTopRVHolder -> {
                holder.bindWithView(this.dataList[position], (position+1).toString())
            }
            is ChartNonRVHolder -> {
                holder.bindWithView(this.dataList[position], (position+1).toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(position < 2){
            1
        }else{
            0
        }
    }

    fun submitList(list: ArrayList<ChartData>){
        this.dataList = list
    }
}