package com.example.conation.src.main.signUp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.conation.R
import com.example.conation.config.BaseActivity
import com.example.conation.config.BaseResponse
import com.example.conation.databinding.ActivitySignUpBinding
import com.example.conation.src.main.login.LoginActivity
import com.example.conation.src.main.signUp.model.UserRequest
import com.example.conation.utils.onMyTextChanged


class SignUpActivity: BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate), AreaInterface, SignUpActivityView{
    private var isOK = false
    private var checkList = booleanArrayOf(false,false,false,false,false,false, false)
    private var regionId = 0

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

        binding.signupPhoneAuthBtn.setOnClickListener {
            binding.signupPhoneAuthLayout.visibility = View.VISIBLE
            timer.start()
        }

        binding.signupAreaEt.setOnClickListener {
            Log.d("로그", "Clic@@")
            val dialog = AreaDialog(this@SignUpActivity)
            dialog.show(supportFragmentManager, dialog.tag)

        }

        binding.signupConfirmBtn.setOnClickListener {
            val request = UserRequest(binding.signupIdEt.text.toString(), binding.signupNicknameEt.text.toString(), binding.signupPwEt.text.toString(),
                binding.signupPwConfirmEt.text.toString(), binding.signupPhoneEt.text.toString(), regionId)
            SignUpService(this).tryPostSignUp(request)
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

    override fun onAreaClicked(area: Int) {
        Log.d("로그", "${area}")

        if(area == 1){
            binding.signupAreaEt.text = getString(R.string.seoul)
            regionId = 1
        }
        else if(area == 2){
            binding.signupAreaEt.text = getString(R.string.gn)
            regionId = 2
        }
        else if(area == 3){
            binding.signupAreaEt.text = getString(R.string.gyeongi)
            regionId = 3
        }
        else if(area == 4){
            binding.signupAreaEt.text = getString(R.string.incheon)
            regionId = 4
        }
        else if(area == 5){
            binding.signupAreaEt.text = getString(R.string.gangwon)
            regionId = 5
        }
        else if(area == 6){
            binding.signupAreaEt.text = getString(R.string.jeju)
            regionId = 6
        }
        else if(area == 7){
            binding.signupAreaEt.text = getString(R.string.daejon)
            regionId = 7
        }
        else if(area == 8){
            binding.signupAreaEt.text = getString(R.string.cb)
            regionId = 8
        }
        else if(area == 9){
            binding.signupAreaEt.text = getString(R.string.sejong)
            regionId = 9
        }
        else if(area == 10){
            binding.signupAreaEt.text = getString(R.string.busan)
            regionId = 10
        }
        else if(area == 11){
            binding.signupAreaEt.text = getString(R.string.ulsan)
            regionId = 11
        }
        else if(area == 12){
            binding.signupAreaEt.text = getString(R.string.daegu)
            regionId = 12
        }
        else if(area == 13){
            binding.signupAreaEt.text = getString(R.string.gb)
            regionId = 13
        }
        else if(area == 14){
            binding.signupAreaEt.text = getString(R.string.gj)
            regionId = 14
        }
        else if(area == 15){
            binding.signupAreaEt.text = getString(R.string.jn)
            regionId = 15
        }
        else if(area == 16){
            binding.signupAreaEt.text = getString(R.string.jb)
            regionId = 16
        }

        checkList[6] = (binding.signupAreaEt.text).isNotEmpty()
        validateET()
    }

    override fun onPostSignUpSuccess(response: BaseResponse) {
        when(response.code){
            1000 -> {
                showCustomToast(response.message.toString())
                finish()
            }
            else -> {
                showCustomToast(response.message.toString())
            }
        }
    }

    override fun onPostSignUpFailure(message: String) {
        showCustomToast(message)
    }

}