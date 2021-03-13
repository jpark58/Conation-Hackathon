package com.example.conation.src.main.chart

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.conation.src.main.chart.model.ChartData
import com.example.conation.src.main.chart.model.ResultCity
import kotlinx.android.synthetic.main.chart_rv_non_top_item.view.*

class ChartNonRVHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var num = itemView.chart_ranking_non_top_num
    private var title = itemView.chart_ranking_non_top_title
    private var points = itemView.chart_ranking_non_top_point

    fun bindWithView(item: ChartData, ranking: String){
        num.text = ranking
        title.text = item.title
        points.text = "%,d".format(item.point) + "p"
    }

}