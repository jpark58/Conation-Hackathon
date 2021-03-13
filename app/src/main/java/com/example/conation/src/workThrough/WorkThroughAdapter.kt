package com.example.conation.src.workThrough

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class WorkThroughAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {
    var fragmentList = ArrayList<Fragment>()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    fun submitList(list: ArrayList<Fragment>){
        this.fragmentList = list
    }
}