package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.after

class IphoneXSMax: Iphone() {
    override fun getHardware() {
        println("Hardware list");
        println("\t- 6.5in Screen");
        println("\t- A12 Chipset");
        println("\t- 4Gb RAM");
        println("\t- 512Gb Memory");
    }
}