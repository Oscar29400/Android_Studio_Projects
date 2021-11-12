package com.osmugo.mvvm_calculator.model

class Calculator{

    sealed class Response{
        class OKResult(val result:Double):Response()
        class RetornoError(val error:String):Response()
        class CapitalError(val error:String):Response()
    }
    data class Request(
        val Capital: Double,
        val Interes: Double,
        val Retorno: Double
    )

    private fun calc(Capital: Double, Interes: Double, Retorno: Double):Double = Capital* Interes/12/(1-Math.pow(1+(Interes/12),-Retorno*12))

    fun calculate(request: Request):Response{

        Thread.sleep(3000)
        if (request.Retorno < 4) {
            return Response.RetornoError("Minimo 4 meses")
        }
        if (request.Capital > 20000) {
            return  Response.CapitalError("Maximo 20000 € de capital")
        }
        return Response.OKResult(calc(request.Capital, request.Interes,request.Retorno))

    }



}