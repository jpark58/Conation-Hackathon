package com.example.conation.src.workThrough

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.conation.R
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentThirdBinding
import com.example.conation.src.main.MainActivity

class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::bind,R.layout.fragment_third) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.workthroughSkipBtn.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}