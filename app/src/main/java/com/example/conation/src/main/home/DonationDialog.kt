package com.example.conation.src.main.home

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.conation.R
import com.example.conation.databinding.DialogDonationBinding

class DonationDialog(val isSuccess: Boolean): DialogFragment() {

    private var binding: DialogDonationBinding? = null
    var windowManager: WindowManager? = null
    var display: Display? = null
    var size: Point? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogDonationBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.setCanceledOnTouchOutside(false)
        windowManager = activity?.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
        display = windowManager!!.defaultDisplay
        size = Point()
        display!!.getSize(size)

        binding!!.dialogDonationOk.setOnClickListener {
            dismiss()
        }
        binding!!.dialogDonaionNext.setOnClickListener {
            dismiss()
        }

        if(isSuccess){
            binding!!.dialogDonationStatus.text = "기부완료!"
            binding!!.dialogImg1.setImageResource(R.drawable.dialog_img1)
            binding!!.dialogShine1.visibility = View.VISIBLE
            binding!!.dialogShine2.setImageResource(R.drawable.dialog_img2)
            binding!!.dialogDonationPoint.visibility = View.VISIBLE
            binding!!.dialogDonationStatus.visibility = View.VISIBLE
            binding!!.donationFailMsg1.visibility = View.GONE
            binding!!.donationFailMsg2.visibility = View.GONE
            binding!!.dialogDonaionNext.text = "다음 광고 보기"
        }else{
            binding!!.dialogDonationStatus.text = "기부실패!"
            binding!!.dialogImg1.setImageResource(R.drawable.dialog_sad)
            binding!!.dialogShine1.visibility = View.GONE
            binding!!.dialogShine2.setImageResource(R.drawable.mess)
            binding!!.dialogDonationPoint.visibility = View.GONE
            binding!!.dialogDonationStatus.visibility = View.GONE
            binding!!.donationFailMsg1.visibility = View.VISIBLE
            binding!!.donationFailMsg2.visibility = View.VISIBLE
            binding!!.dialogDonaionNext.text = "이어서 보기"
        }

    }

    override fun onResume() {
        super.onResume()


        var params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size!!.x
        params?.width = (deviceWidth*0.8).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

}