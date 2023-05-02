package com.coralogix.calculator.client;

public class ApiCurrencyResponse {

    private String conversionRate;
    private String baseCode;


    public void setConversionRate(String conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getConversionRate() {
        return conversionRate;
    }


    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getBaseCode() {
        return baseCode;
    }
}
