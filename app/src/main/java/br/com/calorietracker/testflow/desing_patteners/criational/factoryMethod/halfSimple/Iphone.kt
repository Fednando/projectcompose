package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple

public abstract class Iphone {
    public abstract fun getHardware()

    public fun assemble(){
        println("Assembling all the hardware")
    }

    fun certificates() {
        println("Testing all the certificates")
    }

    fun pack() {
        println("Packing the device")
    }

}