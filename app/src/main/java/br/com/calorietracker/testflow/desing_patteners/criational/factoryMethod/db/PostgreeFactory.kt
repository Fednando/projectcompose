package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.db

class PostgreeFactory : DbFactory() {
    override fun getDb(): Db {
        return Postgree()
    }
}