package br.com.calorietracker.testflow.desing_patteners.abstractFactory.factory.abstractFactory

import br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate.BrazilianCertificate
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate.Certificate
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.packing.BrazilianPacking
import br.com.calorietracker.testflow.desing_patteners.abstractFactory.packing.Packing

class BrazilianRulesAbstractFactory : CountryRulesAbstractFactory {
    override fun getCertificates(): Certificate {
        return BrazilianCertificate()
    }

    override fun getPacking(): Packing {
        return BrazilianPacking()
    }
}