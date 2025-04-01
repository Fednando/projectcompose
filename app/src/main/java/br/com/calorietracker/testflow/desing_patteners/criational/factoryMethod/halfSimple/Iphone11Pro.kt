package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.halfSimple

class Iphone11Pro: Iphone() {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 6.5in Screen");
        println("\t- A13 Chipset");
        println("\t- 4Gb RAM");
        println("\t- 512Gb Memory");
    }
}