package com.trendo.backend;
//eventually rotate towards the yahoo finance api. Can make 100 calls a day, so make sure to be efficient.

//unirest imports
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class CurrenciesPrice {

    // Returning the response object to use in other functions
    public static HttpResponse<JsonNode> createResponse(String id) throws Exception {

        // Requesting response and returning it
        HttpResponse<JsonNode> response = Unirest.get(DataBase.host + id + DataBase.percentage)
                .header("authorization", "Bearer " + DataBase.token).header("x-rapidapi-key", DataBase.apiKey)
                .header("x-rapidapi-host", DataBase.apiHost).asJson();
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

    // Getting currency daily price change from response as a double
    public static double getDailyPercentageAsDouble(String id) throws Exception {
        String percentage = getDailyPercentage(id);
        double conversion = Double.parseDouble(percentage);
        return conversion;

    }

    // Getting currency price from response
    public static String getPrice(String identifier) throws Exception {
        double price = getPriceAsDouble(identifier);
        String roundedPrice = String.valueOf(price);
        return roundedPrice;

    }

    // Getting currency price from response as an integer
    public static double getPriceAsDouble(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String price = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("price");
        // Returning rounded price as a string
        double conversion = Double.parseDouble(price);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        return rounded;

    }

}
