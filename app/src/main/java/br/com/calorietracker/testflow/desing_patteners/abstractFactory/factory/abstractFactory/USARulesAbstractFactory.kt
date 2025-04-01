package br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate.Certificate
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate.USCertificate
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.packing.Packing
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.packing.USPacking

class USARulesAbstractFactory : CountryRulesAbstractFactory {
    override fun getCertificates(): Certificate {
        return USCertificate()
    }

    override fun getPacking(): Packing {
        return USPacking()
    }
}