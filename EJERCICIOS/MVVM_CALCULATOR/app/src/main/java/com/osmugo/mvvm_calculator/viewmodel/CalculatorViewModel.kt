package com.osmugo.mvvm_calculator.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osmugo.mvvm_calculator.model.Calculator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {

    private val Calcul: Calculator = Calculator()

    val cal : MutableLiveData<Double> = MutableLiveData()
    val loading : MutableLiveData<Boolean> = MutableLiveData()
    val error : MutableLiveData<String> = MutableLiveData()
    val errorcap : MutableLiveData<String> = MutableLiveData()

    fun calculate(capital: Double,interes: Double,retorno: Double){

        calculateSealed(capital,interes,retorno)

    }

         fun calculateSealed(capital: Double, interes: Double, retorno: Double) {
            CoroutineScope(Dispatchers.IO).launch {
                loading.postValue(true)
                Calcul.calculate(Calculator.Request(capital,interes,retorno)).also { res ->
                    when(res){
                        is Calculator.Response.OKResult -> {
                            cal.postValue(res.result)
                             }
                        is Calculator.Response.RetornoError -> {
                            error.postValue(res.error)
                        }
                        is Calculator.Response.CapitalError -> {
                            errorcap.postValue(res.error)
                        }
                    }
                }
                loading.postValue(false)
            }
        }
}