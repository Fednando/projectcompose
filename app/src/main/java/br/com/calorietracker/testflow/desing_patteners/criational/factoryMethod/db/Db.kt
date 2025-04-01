package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.db

interface Db {
    fun query(query: String) : String
    fun update()
}