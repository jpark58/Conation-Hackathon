package com.example.conation.src.main.signUp

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.example.conation.databinding.DialogAreaBinding

class AreaDialog(areaInterface: AreaInterface): DialogFragment() {

    private var areaInterface = areaInterface
    private var binding: DialogAreaBinding? = null

    var windowManager: WindowManager? = null
    var display: Display? = null
    var size: Point? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogAreaBinding.inflate(inflater, container, false)
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

        windowManager = activity?.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
        display = windowManager!!.defaultDisplay
        size = Point()
        display!!.getSize(size)

        dialog?.setCanceledOnTouchOutside(false)

        setUpListeners()

    }



    override fun onResume() {
        super.onResume()

        var params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceWidth = size!!.x
        val deviceHeight = size!!.y
        params?.width = (deviceWidth*0.9).toInt()
        params?.height = (deviceHeight*0.9).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    private fun setUpListeners(){

        binding!!.areaSeoul.setOnClickListener {
            this.areaInterface.onAreaClicked(1)
            dismiss()
        }
        binding!!.areaGn.setOnClickListener {
            this.areaInterface.onAreaClicked(2)
            dismiss()
        }
        binding!!.areaGyeonggi.setOnClickListener {
            this.areaInterface.onAreaClicked(3)
            dismiss()
        }
        binding!!.areaIncheon.setOnClickListener {
            this.areaInterface.onAreaClicked(4)
            dismiss()
        }
        binding!!.areaGanwon.setOnClickListener {
            this.areaInterface.onAreaClicked(5)
            dismiss()
        }
        binding!!.areaJeju.setOnClickListener {
            this.areaInterface.onAreaClicked(6)
            dismiss()
        }
        binding!!.areaDaejeon.setOnClickListener {
            this.areaInterface.onAreaClicked(7)
            dismiss()
        }
        binding!!.areaCb.setOnClickListener {
            this.areaInterface.onAreaClicked(8)
            dismiss()
        }
        binding!!.areaSejong.setOnClickListener {
            this.areaInterface.onAreaClicked(9)
            dismiss()
        }
        binding!!.areaBusan.setOnClickListener {
            this.areaInterface.onAreaClicked(10)
            dismiss()
        }
        binding!!.areaUlsan.setOnClickListener {
            this.areaInterface.onAreaClicked(11)
            dismiss()
        }
        binding!!.areaDaegu.setOnClickListener {
            this.areaInterface.onAreaClicked(12)
            dismiss()
        }
        binding!!.areaGb.setOnClickListener {
            this.areaInterface.onAreaClicked(13)
            dismiss()
        }
        binding!!.areaGj.setOnClickListener {
            this.areaInterface.onAreaClicked(14)
            dismiss()
        }
        binding!!.areaJn.setOnClickListener {
            this.areaInterface.onAreaClicked(15)
            dismiss()
        }
        binding!!.areaJb.setOnClickListener {
            this.areaInterface.onAreaClicked(16)
            dismiss()
        }

    }
}