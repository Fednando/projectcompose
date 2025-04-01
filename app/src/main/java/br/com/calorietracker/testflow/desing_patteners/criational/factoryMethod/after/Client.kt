package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after

import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after.factory.Iphone11Factory
import br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after.factory.IphoneXFactory

fun main(){

    val iphoneXFactory = IphoneXFactory()
    val iphone11Factory = Iphone11Factory()

    println("Ordering an Iphone X")
    val iphoneX = iphoneXFactory.orderIphone()
    println(iphoneX)

    println("Ordering an Iphone 11 HighEnd")
    val iphone2 = iphone11Factory.orderIphone()
    println(iphone2)

}
