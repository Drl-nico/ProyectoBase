package com.example.proyectobase.utils

object OPMath {
    fun divi(valor1:Int,valor2: Int):Int{
        return try {
          valor1/valor2
        }catch (e:ArithmeticException){
            println("error dividir cero")
            0
        }finally {
            println("Finally")
        }
    }
}