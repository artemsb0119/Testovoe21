package com.example.testovoe21

import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlin.random.Random

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SettingsFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var buttonClickListener: OnButtonClickListener? = null

    private lateinit var buttonChange: AppCompatButton
    private lateinit var cons1: ConstraintLayout

    interface OnButtonClickListener {
        fun onButtonClicked()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onResume() {
        val sharedPreferences = requireActivity().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        var currentNumber = sharedPreferences.getInt("currentNumber", 1)
        if(currentNumber==1) {
            cons1.setBackgroundResource(R.color.white)
        } else if (currentNumber==2){
            cons1.setBackgroundResource(R.color.light_orange)
        } else if (currentNumber==3){
            cons1.setBackgroundResource(R.color.light_yellow)
        }
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        buttonChange = view.findViewById(R.id.buttonChange)
        cons1 = view.findViewById(R.id.cons1)
        val sharedPreferences = requireActivity().getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        var currentNumber = sharedPreferences.getInt("currentNumber", 1)
        buttonChange.setOnClickListener {
            val min = if (currentNumber == 1) 2 else 1
            val max = if (currentNumber == 3) 2 else 3
            currentNumber = Random.nextInt(min, max + 1)
            val editor = requireActivity().getSharedPreferences("my_preferences", Context.MODE_PRIVATE).edit()
            editor.putInt("currentNumber", currentNumber)
            editor.apply()
            if(currentNumber==1) {
                cons1.setBackgroundResource(R.color.white)
            } else if (currentNumber==2){
                cons1.setBackgroundResource(R.color.light_orange)
            } else if (currentNumber==3){
                cons1.setBackgroundResource(R.color.light_yellow)
            }
            buttonClickListener?.onButtonClicked()
        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun setOnButtonClickListener(listener: OnButtonClickListener) {
        buttonClickListener = listener
    }
}