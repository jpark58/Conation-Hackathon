package com.example.conation.src.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.conation.R
import com.example.conation.config.ApplicationClass
import com.example.conation.config.BaseActivity
import com.example.conation.databinding.ActivityMainBinding
import com.example.conation.src.main.chart.ChartFragment
import com.example.conation.src.main.home.HomeFragment
import com.example.conation.src.main.login.LoginActivity
import com.example.conation.src.main.mypage.MyPageFragment
import com.example.conation.src.main.signUp.SignUpActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()

        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when(item.itemId){
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_chart -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, ChartFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }

                    R.id.menu_main_btm_nav_mypage -> {
                        val jwt = ApplicationClass.sSharedPreferences.getString(ApplicationClass.X_ACCESS_TOKEN, "na")

                        if(jwt == "na"){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }else{
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyPageFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }

                    }
                }
                false
            }

        )
    }

    override fun onResume() {
        super.onResume()
        invalidateOptionsMenu()
    }
}