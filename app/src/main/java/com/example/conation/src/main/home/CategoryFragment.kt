package com.example.conation.src.main.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.conation.R
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentCategoryBinding
import com.example.conation.src.main.home.model.Dummy
import com.example.conation.src.main.home.model.category.CategoryRVAdapter
import com.example.conation.src.main.home.model.recommend.RecommendRVAdapter

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::bind, R.layout.fragment_category) {
    private var dataList = ArrayList<Dummy>()
    private lateinit var dataAdapter: CategoryRVAdapter
    val temp1 = Dummy("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "na", "아무광고나 이것저것", "18,423,233 views", "100p")
    val temp2 = Dummy("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "na", "아무광고나 이것저것", "18,423,233 views", "100p")
    val temp3 = Dummy("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "na", "아무광고나 이것저것", "18,423,233 views", "100p")
    val temp4 = Dummy("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "na", "아무광고나 이것저것", "18,423,233 views", "100p")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataList.add(temp1)
        dataList.add(temp2)
        dataList.add(temp3)
        dataList.add(temp4)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.dataAdapter = CategoryRVAdapter()
        this.dataAdapter.submitList(dataList)
        binding.categoryRecyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.categoryRecyclerview.adapter = this.dataAdapter

        dataAdapter.setOnClickListener(onClicked)
    }

    private val onClicked = object: CategoryRVAdapter.OnItemClickListener{
        override fun onClicked(data: Dummy) {
            val intent = Intent(activity, VideoActivity::class.java)
            intent.putExtra("data", data)
            startActivity(intent)
        }

    }
}