package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.db

fun main(){
    val oracle = OracleFactory().getDb()
    oracle.query("Select * from client")
    oracle.update()

    val postgree = PostgreeFactory().getDb()
    postgree.query("Select * from client")
    oracle.update()
}