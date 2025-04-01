package br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.CountryRulesAbstractFactory
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.model.Iphone

abstract class IphoneFactory(rules: CountryRulesAbstractFactory) {

    fun orderIphone(level: String): Iphone {
        return createIphone(level).apply {
            getHardware()
            assemble()
            certificates()
            pack()
        }
    }


    protected abstract fun createIphone(level: String): Iphone
}