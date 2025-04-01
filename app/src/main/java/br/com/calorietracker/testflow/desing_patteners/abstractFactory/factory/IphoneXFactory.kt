package br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.Iphone
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.IphoneX
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.IphoneXSMax

class IphoneXFactory(
    private val rules: CountryRulesAbstractFactory
) : IphoneFactory(rules) {

    override fun createIphone(level: String): Iphone {
        return if(level == "standard") {
            return  IphoneX(rules);
        } else if(level == "highEnd") {
            return  IphoneXSMax(rules);
        } else throw IllegalArgumentException("Invalid level")
    }
}