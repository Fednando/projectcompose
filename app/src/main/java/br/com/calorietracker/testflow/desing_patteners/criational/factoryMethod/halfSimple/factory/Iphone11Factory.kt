package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple.factory

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone11
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone11Pro

class Iphone11Factory: IphoneFactory() {
    override fun createIphone(level: String): Iphone {
        return if(level == "highEnd") {
            Iphone11Pro()
        }else if(level == "standard") {
            Iphone11()
        } else {
           throw IllegalArgumentException("Iphone not found")
        }
    }
}