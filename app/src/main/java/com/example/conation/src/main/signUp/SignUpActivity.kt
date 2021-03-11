package com.example.conation.src.main.signUp

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.conation.R
import com.example.conation.config.BaseActivity
import com.example.conation.databinding.ActivitySignUpBinding
import com.example.conation.utils.onMyTextChanged

class SignUpActivity: BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate) {
    private var isOK = false
    private var isResend = false
    private var checkList = booleanArrayOf(false,false,false,false,false,false, false)
    private var isPhoneValid = false

    val timer: CountDownTimer = object : CountDownTimer(300000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            //update the UI with the new count
            var count = millisUntilFinished / 1000

            if(count - ((count/60)*60) >= 10){
                binding.signupPhoneAuthTimer.text = (count/60).toString() + ":" + (count - ((count/60)*60))
            }else{
                binding.signupPhoneAuthTimer.text = (count/60).toString() + ":0" + (count - ((count/60)*60))
            }
        }

        override fun onFinish() {
            binding.signupPhoneAuthTimer.text = "00:00"
            binding.signupPhoneAuthBtn.text = "재전송"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.signupToolbar.toolbarBack)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        binding.signupToolbar.toolbarTitle.text = "회원가입"

        binding.signupIdEt.onMyTextChanged {
            checkList[0] = (binding.signupIdEt.text).isNotEmpty()
            validateET()
        }

        binding.signupNicknameEt.onMyTextChanged {
            checkList[1] = (binding.signupNicknameEt.text).isNotEmpty()
            validateET()
        }

        binding.signupPwEt.onMyTextChanged {
            checkList[2] = (binding.signupPwEt.text).isNotEmpty()
            validateET()
        }

        binding.signupPwConfirmEt.onMyTextChanged {
            checkList[3] = (binding.signupPwConfirmEt.text).isNotEmpty()
            validateET()
        }

        binding.signupPhoneEt.onMyTextChanged {
            checkList[4] = (binding.signupPhoneEt.text).isNotEmpty()
            validateET()
        }

        binding.signupPhoneAuthMsgEt.onMyTextChanged {
            checkList[5] = (binding.signupPhoneAuthMsgEt.text).isNotEmpty()
            validateET()
        }

        binding.signupAreaEt.onMyTextChanged {
            checkList[6] = (binding.signupAreaEt.text).isNotEmpty()
            validateET()
        }

        binding.signupPhoneAuthBtn.setOnClickListener {
            binding.signupPhoneAuthLayout.visibility = View.VISIBLE
            timer.start()
        }
    }

    fun validateET(){
        var flag = true
        for(temp in checkList){
            if(!temp){
                flag = false
            }
        }

        if(flag &&
            binding.signupPwConfirmEt.text.toString() == binding.signupPwEt.text.toString()){
            binding.signupConfirmBtn.setBackgroundResource(R.drawable.roundrec_design_active_bg)
            isOK = true
        }else{
            binding.signupConfirmBtn.setBackgroundResource(R.drawable.roundrec_design_inactive_bg)
        }
    }

}