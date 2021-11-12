package com.osmugo.mvvm_calculator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.osmugo.mvvm_calculator.databinding.FragmentCalcBinding
import com.osmugo.mvvm_calculator.model.Calculator
import com.osmugo.mvvm_calculator.viewmodel.CalculatorViewModel
import java.lang.Exception

class Calc_Fragment : Fragment() {

    private lateinit var binding: FragmentCalcBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentCalcBinding
            .inflate(inflater, container, false)
            .also { binding = it }.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calcvistamodelo : CalculatorViewModel = ViewModelProvider(this)[
                CalculatorViewModel::class.java
        ]
        binding.btnCalculate.setOnClickListener {


            binding.progressCircular.visibility = View.VISIBLE

            val capital = binding.etcapital.text.toString().toDouble()
            val interes = binding.etinteres.text.toString().toDouble()
            val retorno = binding.etretorno.text.toString().toDouble()

            calcvistamodelo.calculate(capital,interes,retorno)
            binding.progressCircular.visibility = View.GONE
        }
        calcvistamodelo.cal.observe(viewLifecycleOwner) {
            resultado ->
                binding.resultado.text = resultado.toString()
        }
        calcvistamodelo.loading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressCircular.visibility = View.VISIBLE
            } else {
                binding.progressCircular.visibility = View.GONE
            }
        }
        calcvistamodelo.error.observe(viewLifecycleOwner) {
            errorretorno ->
             binding.etretorno.error = errorretorno
        }
        calcvistamodelo.errorcap.observe(viewLifecycleOwner) {
            errorCapital ->
            binding.etcapital.error = errorCapital
        }
    }
}