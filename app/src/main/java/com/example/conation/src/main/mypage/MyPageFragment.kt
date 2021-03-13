package com.example.conation.src.main.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.conation.R
import com.example.conation.config.ApplicationClass
import com.example.conation.config.BaseFragment
import com.example.conation.databinding.FragmentMyPageBinding
import com.example.conation.src.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mypageLogoutBtn.setOnClickListener {
            val editor = ApplicationClass.sSharedPreferences.edit()
            editor.putString(ApplicationClass.X_ACCESS_TOKEN, "na")
            editor.apply()

            activity?.main_btm_nav?.selectedItemId = R.id.menu_main_btm_nav_home
            fragmentManager?.beginTransaction()
                ?.replace(R.id.main_frm, HomeFragment())
                ?.commitAllowingStateLoss()
        }

        binding.mypagePresentBtn.setOnClickListener {
            val dialog = DrawDialog()
            dialog.show(childFragmentManager, dialog.tag)
        }
    }
}