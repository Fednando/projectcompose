package br.com.calorietracker.testflow.desing_patteners.abstractFactory.model

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory

class IphoneX(rules: CountryRulesAbstractFactory): Iphone(rules) {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 5.8in Screen");
        println("\t- A11 Chipset");
        println("\t- 3Gb RAM");
        println("\t- 256Gb Memory");
    }
}