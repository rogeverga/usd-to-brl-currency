package com.dollarquotation.services

import com.google.gson.JsonObject
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import org.codehaus.groovy.grails.commons.GrailsApplication

class UnitedStatesDollarService {

    GrailsApplication grailsApplication

    String getBrazilRealCurrency() {
        String url = grailsApplication.config.currencyAPI.url + grailsApplication.config.currencyAPI.unitedStatesDollarCurrency

        RestResponse response = new RestBuilder().get(url) {
            contentType grailsApplication.config.currencyAPI.contentType.toString()
            accept JsonObject
        }

        String brl = response.responseEntity.body.rates.BRL.toString()

        return brl
    }

}