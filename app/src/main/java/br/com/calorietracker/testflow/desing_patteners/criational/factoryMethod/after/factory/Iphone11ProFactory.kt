package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after.factory

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model.Iphone11Pro

class Iphone11ProFactory: IphoneFactory() {
    override fun createIphone(): Iphone {
        return Iphone11Pro()
    }
}