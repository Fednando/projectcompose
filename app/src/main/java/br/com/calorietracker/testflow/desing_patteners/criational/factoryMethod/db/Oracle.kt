package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.db

class Oracle : Db {
    override fun query(query: String): String {
        println("Querying data")
        return "Client"
    }

    override fun update() {
        println("Update data")
    }
}