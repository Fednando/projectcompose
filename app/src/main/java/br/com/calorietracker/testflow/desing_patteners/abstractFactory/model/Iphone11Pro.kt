package br.com.calorietracker.testflow.desing_patteners.abstractFactory.model

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory

class Iphone11Pro(rules: CountryRulesAbstractFactory): Iphone(rules) {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 6.5in Screen");
        println("\t- A13 Chipset");
        println("\t- 4Gb RAM");
        println("\t- 512Gb Memory");
    }
}