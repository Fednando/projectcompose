package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.before.model

fun main(){

    println("Ordering an Iphone X")
    val iphoneX = orderIphone("X", "standard")
    println(iphoneX)

    println("Ordering an Iphone 11 HighEnd")
    val iphone2 = orderIphone("11", "highEnd")
    println(iphone2)

}

fun orderIphone(generation: String, level: String): Iphone? {
    var device : Iphone? = null

    if(generation == "X") {
        if(level == "standard") {
            device = IphoneX()
        }else if(level == "premium") {
            device = IphoneXSMax()
        }
    }else if(generation == "11") {
        if(level == "standard") {
            device = Iphone11()
        }else if(level == "highEnd") {
            device = Iphone11Pro()
        }
    }

    device?.getHardware()
    device?.assemble()
    device?.certificates()
    device?.pack()

    return device
}
