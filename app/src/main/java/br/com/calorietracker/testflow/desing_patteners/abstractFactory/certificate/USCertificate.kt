package br.com.calorietracker.testflow.desing_patteners.abstractFactory.certificate

class USCertificate : Certificate {
    override fun applyCertification(): String {
        return "\t- Certificado USA"
    }
}