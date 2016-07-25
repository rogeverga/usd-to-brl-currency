package com.dollarquotation.jobs

import com.dollarquotation.services.UnitedStatesDollarService
import grails.plugin.slack.SlackService
import org.codehaus.groovy.grails.commons.GrailsApplication

class RetrieveUnitedStatesDollarToBrazilRealQuotationAndSendToSlackAPPJob {

    GrailsApplication grailsApplication
    SlackService slackService
    UnitedStatesDollarService unitedStatesDollarService

    static triggers = {
      simple repeatInterval: 60000l
    }

    void execute() {
        print unitedStatesDollarService.getBrazilRealCurrency()

        /*slackService.send {
            text "Dollar (USD) to Brazil Real (BRL) currency: " + unitedStatesDollarService.getBrazilRealCurrency()
            username grailsApplication.config.slack.userName
        }*/
    }

}
