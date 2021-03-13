package com.example.conation.src.main.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.conation.R
import com.example.conation.config.ApplicationClass
import com.example.conation.config.BaseActivity
import com.example.conation.databinding.ActivityLoginBinding
import com.example.conation.src.main.login.model.LoginResponse
import com.example.conation.src.main.login.model.PostLoginRequest
import com.example.conation.src.main.signUp.SignUpActivity
import com.example.conation.utils.onMyTextChanged

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate), LoginActivityView {
    private var isId = false
    private var isPW = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding.loginSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        }

        binding.loginId.onMyTextChanged {
            isId = binding.loginId.text.toString().isNotEmpty()

            if(isId && isPW){
                binding.loginBtn.setBackgroundResource(R.drawable.roundrec_design_active_bg)
            }else{
                binding.loginBtn.setBackgroundResource(R.drawable.roundrec_design_inactive_bg)
            }
        }

        binding.loginPw.onMyTextChanged {
            isPW = binding.loginPw.text.toString().isNotEmpty()

            if(isId && isPW){
                binding.loginBtn.setBackgroundResource(R.drawable.roundrec_design_active_bg)
            }else{
                binding.loginBtn.setBackgroundResource(R.drawable.roundrec_design_inactive_bg)
            }
        }

        binding.loginBtn.setOnClickListener {
            if(isPW && isId){
                val request = PostLoginRequest(binding.loginPw.text.toString(), binding.loginId.text.toString())
                LoginService(this).tryPostLogin(request)
            }
        }

    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        when(response.code){
            1000 -> {
                showCustomToast(response.message.toString())
                Log.d("로그", "In success")
                val jwt = response.result
                val editor = ApplicationClass.sSharedPreferences.edit()
                editor.putString(ApplicationClass.X_ACCESS_TOKEN, jwt)
                editor.apply()
                finish()
            }
            else -> {
                showCustomToast(response.message.toString())
            }
        }
    }

    override fun onPostLoginFailure(message: String) {
        showCustomToast(message)
    }
}