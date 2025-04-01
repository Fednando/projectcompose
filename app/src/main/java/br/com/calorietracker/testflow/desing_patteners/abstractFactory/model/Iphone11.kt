package br.com.calorietracker.testflow.desing_patteners.abstractFactory.model

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory

class Iphone11(rules: CountryRulesAbstractFactory): Iphone(rules) {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 6.1in Screen");
        println("\t- A13 Chipset");
        println("\t- 4Gb RAM");
        println("\t- 256Gb Memory");
    }
}