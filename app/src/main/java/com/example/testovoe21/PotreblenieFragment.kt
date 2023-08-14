package com.example.testovoe21

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PotreblenieFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var cons1: ConstraintLayout

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var textViewData: TextView
    private lateinit var textViewData2: TextView

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
        val view = inflater.inflate(R.layout.fragment_potreblenie, container, false)
        editText1 = view.findViewById(R.id.editText1)
        editText2 = view.findViewById(R.id.editText2)
        editText3 = view.findViewById(R.id.editText3)
        textViewData = view.findViewById(R.id.textViewData)
        textViewData2 = view.findViewById(R.id.textViewData2)
        cons1 = view.findViewById(R.id.cons1)

        editText1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Вызывается перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Вызывается во время изменения текста
            }

            override fun afterTextChanged(s: Editable?) {
                if (!TextUtils.isEmpty(editText1.text) && !TextUtils.isEmpty(editText2.text)) {
                    val fuelSpent = editText1.text.toString().toDouble()
                    val distance = editText2.text.toString().toDouble()
                    val fuelConsumption = (fuelSpent / distance) * 100
                    val formattedFuelConsumption = String.format("%.2f", fuelConsumption)
                    textViewData.text = "Fuel consumption per 100 km: $formattedFuelConsumption"
                }
                else {
                    textViewData.text = "No data available"
                }
                if (!TextUtils.isEmpty(editText1.text) && !TextUtils.isEmpty(editText2.text) && !TextUtils.isEmpty(editText3.text)) {
                    val fuelSpent = editText1.text.toString().toDouble()
                    val distance = editText2.text.toString().toDouble()
                    val fuelConsumption = (fuelSpent / distance) * 100
                    val price = editText3.text.toString().toDouble() * fuelConsumption
                    val formattedFuelConsumption = String.format("%.2f", price)
                    textViewData2.text = "Fuel cost per 100 km: $formattedFuelConsumption"
                }
                else {
                    textViewData2.text = ""
                }
            }

        })
        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Вызывается перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Вызывается во время изменения текста
            }

            override fun afterTextChanged(s: Editable?) {
                if (!TextUtils.isEmpty(editText1.text) && !TextUtils.isEmpty(editText2.text)) {
                    val fuelSpent = editText1.text.toString().toDouble()
                    val distance = editText2.text.toString().toDouble()
                    val fuelConsumption = (fuelSpent / distance) * 100
                    val formattedFuelConsumption = String.format("%.2f", fuelConsumption)
                    textViewData.text = "Fuel consumption per 100 km: $formattedFuelConsumption"
                }
                else {
                    textViewData.text = "No data available"
                }
                if (!TextUtils.isEmpty(editText1.text) && !TextUtils.isEmpty(editText2.text) && !TextUtils.isEmpty(editText3.text)) {
                    val fuelSpent = editText1.text.toString().toDouble()
                    val distance = editText2.text.toString().toDouble()
                    val fuelConsumption = (fuelSpent / distance) * 100
                    val price = editText3.text.toString().toDouble() * fuelConsumption
                    val formattedFuelConsumption = String.format("%.2f", price)
                    textViewData2.text = "Fuel cost per 100 km: $formattedFuelConsumption"
                }
                else {
                    textViewData2.text = ""
                }
            }
        })
        editText3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Вызывается перед изменением текста
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Вызывается во время изменения текста
            }

            override fun afterTextChanged(s: Editable?) {
                if (!TextUtils.isEmpty(editText1.text) && !TextUtils.isEmpty(editText2.text)) {
                    val fuelSpent = editText1.text.toString().toDouble()
                    val distance = editText2.text.toString().toDouble()
                    val fuelConsumption = (fuelSpent / distance) * 100
                    val formattedFuelConsumption = String.format("%.2f", fuelConsumption)
                    textViewData.text = "Fuel consumption per 100 km: $formattedFuelConsumption"
                }
                else {
                    textViewData.text = "No data available"
                }
                if (!TextUtils.isEmpty(editText1.text) && !TextUtils.isEmpty(editText2.text) && !TextUtils.isEmpty(editText3.text)) {
                    val fuelSpent = editText1.text.toString().toDouble()
                    val distance = editText2.text.toString().toDouble()
                    val fuelConsumption = (fuelSpent / distance) * 100
                    val price = editText3.text.toString().toDouble() * fuelConsumption
                    val formattedFuelConsumption = String.format("%.2f", price)
                    textViewData2.text = "Fuel cost per 100 km: $formattedFuelConsumption"
                }
                else {
                    textViewData2.text = ""
                }
            }

        })
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PotreblenieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}