package br.com.calorietracker.testflow.desing_patteners.abstractFactory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.IPhone11Factory
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.IphoneXFactory
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.BrazilianRulesAbstractFactory
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory.USARulesAbstractFactory

fun main(){
    val rules = BrazilianRulesAbstractFactory()
    val iphoneX = IphoneXFactory(rules)
    val iphone11 = IPhone11Factory(rules)

    iphoneX.orderIphone("standard")
    iphone11.orderIphone("highEnd")
    println(iphoneX)
    println(iphone11)


    val rules2 = USARulesAbstractFactory()
    val iphoneX2 = IphoneXFactory(rules2)
    val iphone112 = IPhone11Factory(rules2)

    iphoneX2.orderIphone("standard")
    iphone112.orderIphone("highEnd")
    println(iphoneX2)
    println(iphone112)


}