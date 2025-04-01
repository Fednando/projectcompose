package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after.factory

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone11

class Iphone11Factory: IphoneFactory() {
    override fun createIphone(): Iphone {
        return Iphone11()
    }
}