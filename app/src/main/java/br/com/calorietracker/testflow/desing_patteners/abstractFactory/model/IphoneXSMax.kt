package br.com.calorietracker.testflow.desing_patteners.abstractFactory.model

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory

class IphoneXSMax(rules: CountryRulesAbstractFactory): Iphone(rules) {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 6.5in Screen");
        println("\t- A12 Chipset");
        println("\t- 4Gb RAM");
        println("\t- 512Gb Memory");
    }
}