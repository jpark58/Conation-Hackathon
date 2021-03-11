package com.example.conation.src.main.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {
    var fragmentList = ArrayList<Fragment>()
    var titleList = ArrayList<String>()

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    fun submitList(list: ArrayList<Fragment>, titles: ArrayList<String>){
        this.fragmentList = list
        this.titleList = titles
    }
}