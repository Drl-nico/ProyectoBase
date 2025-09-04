package com.example.proyectobase.utils

object OPMath {
    fun sumar(valor1: Int,valor2: Int):Int {
        return valor1 + valor2
    }
    fun restar(valor1: Int,valor2: Int):Int {
        return valor1 - valor2
    }
    fun multi(valor1: Int,valor2: Int):Int {
        return valor1 * valor2
    }
    fun divi(valor1:Int,valor2: Int):Int{
        try {
            return valor1/valor2
        }catch (e: ArithmeticException){
            return 0
        }finally {
            println("ERROR .... NO SE PUEDE DIVIDIR POR CERO")
        }

    }

}