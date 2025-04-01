package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after.factory

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone

abstract class IphoneFactory {
    fun orderIphone(): Iphone {
        return createIphone().apply {
            getHardware()
            assemble()
            certificates()
            pack()
        }
    }

    protected abstract fun createIphone(): Iphone
}