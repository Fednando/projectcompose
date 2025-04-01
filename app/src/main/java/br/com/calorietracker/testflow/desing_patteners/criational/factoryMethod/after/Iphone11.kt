package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after

class Iphone11: Iphone() {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 6.1in Screen");
        println("\t- A13 Chipset");
        println("\t- 4Gb RAM");
        println("\t- 256Gb Memory");
    }
}