package com.example.conation.src.workThrough

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.conation.config.BaseActivity
import com.example.conation.databinding.ActivityWorkThroughBinding
import com.example.conation.src.main.home.CategoryFragment
import com.example.conation.src.main.home.HomeAdapter
import com.example.conation.src.main.home.PriceFragment
import com.example.conation.src.main.home.RecommendFragment

class WorkThroughActivity : BaseActivity<ActivityWorkThroughBinding>(ActivityWorkThroughBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        setUpTab()
    }

    private fun setUpTab(){
        val adapter = WorkThroughAdapter(supportFragmentManager)
        val fragmentList = ArrayList<Fragment>()
        fragmentList.add(FirstFragment())
        fragmentList.add(SecondFragment())
        fragmentList.add(ThirdFragment())
        adapter.submitList(fragmentList)

        binding.workthroughViewpager.adapter = adapter
    }
}