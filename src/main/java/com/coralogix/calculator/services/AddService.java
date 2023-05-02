package com.coralogix.calculator.services;

import com.coralogix.calculator.client.ApiCurrencyClient;
import com.coralogix.calculator.client.ApiCurrencyResponse;
import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.repository.ExchangeRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AddService {
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private ExchangeRepository repository;
    @Autowired
    private ApiCurrencyClient apiCurrencyClient;

   public List <ExchangeRate> getAllExchangeRate() {
        return repository.findAll();
    }


    public ExchangeRate getEchangeRateApiCrrency(String oringCurrency, String finalCurrency) {

        JsonNode response = apiCurrencyClient.find(oringCurrency, finalCurrency);
        String conversion = response.get("conversion_rate").asText();
        String targetCode= response.get("target_code").asText();
        String baseCode = response.get("base_code").asText();
        String timeLastUpdateUtc = response.get("time_last_update_utc").asText();
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setConversionRate(conversion);
        exchangeRate.setFinalCurrency(targetCode);
        exchangeRate.setOriginCurrency(baseCode);
        exchangeRate.setDate(timeLastUpdateUtc);
        exchangeRate.setValue(conversion);


        repository.save(exchangeRate);
        return exchangeRate;
    }
}
