package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple.factory

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.IphoneX
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.IphoneXSMax

class IphoneXFactory: IphoneFactory() {
    override fun createIphone(level: String): Iphone {
        return if(level == "standard") {
            IphoneX()
        } else if(level == "highEnd") {
            IphoneXSMax()
        } else {
            throw IllegalArgumentException("Iphone not found")
        }
    }
}