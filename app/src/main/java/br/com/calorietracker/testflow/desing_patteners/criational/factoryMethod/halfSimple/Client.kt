package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple.factory.Iphone11Factory
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple.factory.IphoneXFactory


fun main(){

    val iphoneXFactory = IphoneXFactory()
    val iphone11Factory = Iphone11Factory()

    println("Ordering an Iphone X")
    val iphoneX = iphoneXFactory.orderIphone("standard")
    println(iphoneX)

    println("Ordering an Iphone 11 HighEnd")
    val iphone2 = iphone11Factory.orderIphone("highEn")
    println(iphone2)

}
