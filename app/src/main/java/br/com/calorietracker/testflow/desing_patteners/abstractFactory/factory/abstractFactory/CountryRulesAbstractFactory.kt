package br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate.Certificate
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.packing.Packing

interface CountryRulesAbstractFactory {
    fun getCertificates() : Certificate
    fun getPacking() : Packing
}