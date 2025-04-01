package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.db

abstract class DbFactory {
    abstract fun getDb(): Db
}