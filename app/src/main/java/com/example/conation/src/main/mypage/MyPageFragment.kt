package com.example.conation.src.main.mypage

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
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
import com.example.conation.src.main.mypage.model.DrawResponse
import com.example.conation.src.main.mypage.model.MyPageResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.DecimalFormat

class MyPageFragment : BaseFragment<FragmentMyPageBinding>(FragmentMyPageBinding::bind, R.layout.fragment_my_page), MyPageFragmentView {

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
            MyPageService(this).tryGetDraw()
        }

        MyPageService(this).tryPostMyPage()

    }

    override fun onPostMyPageSuccess(response: MyPageResponse) {
        when(response.code){
            1000 -> {
                var formatter = DecimalFormat("###,###")
                binding.mypageNicknameTv.text = response.result.nickname
                if(!response.result.point.isNullOrEmpty()){
                    binding.mypagePointTv.text = formatter.format(response.result.point.toInt())+"p"
                }

            }
            else -> {
                showCustomToast(response.message.toString())
            }
        }
    }

    override fun onPostMyPageFailure(message: String) {
        showCustomToast(message)
    }

    override fun onGetDrawSuccess(response: DrawResponse) {
        when(response.code){
            1000 -> {
                showCustomToast(response.message.toString())
                if(response.result.drawResult == "당첨 !!"){
                    val dialog = DrawDialog()
                    dialog.show(childFragmentManager, dialog.tag)
                }else{
                    val dialog = DrawFailDialog()
                    dialog.show(childFragmentManager, dialog.tag)
                }
            }
            else -> {
                showCustomToast(response.message.toString())
            }
        }
    }

    override fun onGetDrawFailure(message: String) {
        showCustomToast(message)
    }

    fun Int.toPx(context: Context) = this * context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT
}