package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple.factory

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone

abstract class IphoneFactory {
    fun orderIphone(level : String): Iphone {
        return createIphone(level).apply {
            getHardware()
            assemble()
            certificates()
            pack()
        }
    }

    protected abstract fun createIphone(level: String): Iphone
}