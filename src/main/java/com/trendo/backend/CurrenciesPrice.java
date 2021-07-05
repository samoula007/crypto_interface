package com.trendo.backend;

//unirest imports
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class CurrenciesPrice {

    // Returning the response object to use in other functions
    public static HttpResponse<JsonNode> createResponse(String id) throws Exception {

        // General Variables for api
        String apiKey = "5dcc767e21msh6eb86612ad393aep192d68jsn24088a077eae";
        String apiHost = "bravenewcoin.p.rapidapi.com";
        String host = "https://bravenewcoin.p.rapidapi.com/market-cap?assetId=";
        String percentage = "&percentChange=true";
        // This one changes each 24h @getToken at
        // "https://rapidapi.com/BraveNewCoin/api/bravenewcoin?endpoint=apiendpoint_d040b5cb-b6da-4628-bb86-fef663f635dc"
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik5EVXhNRGhHT0VReE56STVOelJCTTBJM1FrUTVOa0l4TWtRd1FrSTJSalJFTVRaR1F6QTBOZyJ9.eyJpc3MiOiJodHRwczovL2F1dGguYnJhdmVuZXdjb2luLmNvbS8iLCJzdWIiOiJvQ2RRb1pvSTk2RVJFOUhZM3NRN0ptYkFDZkJmNTVSWUBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9hcGkuYnJhdmVuZXdjb2luLmNvbSIsImlhdCI6MTYyNTM5NDQxNCwiZXhwIjoxNjI1NDgwODE0LCJhenAiOiJvQ2RRb1pvSTk2RVJFOUhZM3NRN0ptYkFDZkJmNTVSWSIsInNjb3BlIjoicmVhZDppbmRleC10aWNrZXIgcmVhZDpyYW5raW5nIHJlYWQ6bXdhIHJlYWQ6Z3dhIHJlYWQ6YWdncmVnYXRlcyByZWFkOm1hcmtldCByZWFkOmFzc2V0IHJlYWQ6b2hsY3YgcmVhZDptYXJrZXQtY2FwIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.EMtY2opI40oZ_C2GhQxFGSns0_-AAF0de7s5CY868KPMZ_Qz7B5U3hwzxmJtQFv84D02JBkGaQAivJp3u3CCU5q2Gf71yW-asFUJ1tP2XRbQW5rggflqxpTzgXMZgViw--2IwduejH_SeJmGD0R1YIdu2CkuEb-xg7wagfSLEFoR_51EhFm_dOcooYwPg73oMfN9-eHcys3RE_CPodKkq63CT94BCEsywv2NyinroTjuN4ao11D1TSXYFSSybSNo-k10UpGyuCkorHJYGd5vBQLIs12K-7bK-35O0YJ5URbn_8w8QuRULvyb0Ca_r0RSIeh4NCvNnNgU6ypmX0UZ_Q";

        // Requesting response and returning it
        HttpResponse<JsonNode> response = Unirest.get(host + id + percentage).header("authorization", "Bearer " + token)
                .header("x-rapidapi-key", apiKey).header("x-rapidapi-host", apiHost).asJson();
        return response;

    }

    // Getting currency daily price change from response
    public static String getDailyPercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily price change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("pricePercentChange").optString("change24h");
        return dailyPercentage;

    }

    // Getting currency price from response
    public static String getPrice(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String price = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("price");
        // Returning rounded price as a string
        double conversion = Double.parseDouble(price);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        String roundedPrice = String.valueOf(rounded);
        return roundedPrice;

    }

}
