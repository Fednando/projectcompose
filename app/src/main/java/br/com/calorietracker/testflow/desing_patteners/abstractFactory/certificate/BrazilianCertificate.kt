package br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate

class BrazilianCertificate : Certificate {
    override fun applyCertification(): String {
        return "\t- Certificado Brasileiro"
    }
}