package br.com.calorietracker.testflow.desing_patteners.abstractFactory.packing

class USPacking: Packing {
    override fun pack(): String {
        return "\t	- Empacotando em Inglês"
    }
}