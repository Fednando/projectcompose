package br.com.calorietracker.testflow.desing_patteners.criational.factoryMethod.db

class OracleFactory : DbFactory() {
    override fun getDb(): Db {
        return Oracle()
    }
}