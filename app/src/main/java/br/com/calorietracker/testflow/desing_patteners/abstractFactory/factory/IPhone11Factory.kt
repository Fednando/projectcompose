package br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.Iphone
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.Iphone11
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.Iphone11Pro

class IPhone11Factory( val rules: CountryRulesAbstractFactory
) : IphoneFactory(rules) {

    override fun createIphone(level: String): Iphone {
        return if(level == "standard") {
            return  Iphone11(rules);
        } else if(level == "highEnd") {
            return  Iphone11Pro(rules);
        } else throw IllegalArgumentException("Invalid level")
    }
}