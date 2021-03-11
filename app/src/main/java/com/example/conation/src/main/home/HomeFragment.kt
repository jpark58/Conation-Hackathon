package com.example.conation.src.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.conation.R
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {

    private var array = ArrayList<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        array.add("추천순")
        array.add("금액 높은순")
        array.add("카테고리")
        setUpTab()
    }

    private fun setUpTab(){
        val adapter = HomeAdapter(childFragmentManager)
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(RecommendFragment())
        fragmentList.add(PriceFragment())
        fragmentList.add(CategoryFragment())
        adapter.submitList(fragmentList, array)

        binding.homeViewpager.adapter = adapter
        binding.homeTabLayout.setupWithViewPager(binding.homeViewpager)
    }

}