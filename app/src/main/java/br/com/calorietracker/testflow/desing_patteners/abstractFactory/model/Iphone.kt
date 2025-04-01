package br.com.calorietracker.testflow.desing_patteners.abstractFactory.model

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory

abstract class Iphone(
    private val rules: CountryRulesAbstractFactory
) {
    abstract fun getHardware()

    fun assemble() {
        println("Assembling all the hardware")
    }

    fun certificates() {
        println("Testing all the certificates")
        println(rules.getCertificates())
    }

    fun pack() {
        println("Packing the Iphone")
        println(rules.getPacking())
    }
}