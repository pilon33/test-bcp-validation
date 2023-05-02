package com.coralogix.calculator.client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@FeignClient(name = "api-currency" , url = "https://v6.exchangerate-api.com/v6/1227cf5d13731ad6c251bc00")
public interface ApiCurrencyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pair/{originCurrency}/{finalCurrency}", consumes = "application/json")
    JsonNode find (@PathVariable("originCurrency") String originCurrency , @PathVariable("finalCurrency") String finalCurrency);

}
