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
        WriteToData.jumpLine("getDailyPricePercentChange " + dailyPercentage, WriteToData.getCurrencyByIdentifier(id));
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
        WriteToData.jumpLine("getPrice " + roundedPrice, WriteToData.getCurrencyByIdentifier(identifier));
        return roundedPrice;

    }

    // Getting currency price from response as a double
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

    // Getting free float supply as double from response
    public static double getFFSupplyAsDouble(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String FFSupply = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("freeFloatSupply");
        // Returning rounded free float supply as a string
        double conversion = Double.parseDouble(FFSupply);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        return rounded;
    }

    // Getting currency free float supply from response
    public static String getFFSupply(String identifier) throws Exception {
        double FFSupply = getFFSupplyAsDouble(identifier);
        String roundedFFSupply = String.valueOf(FFSupply);
        WriteToData.jumpLine("getFFSupply " + roundedFFSupply, WriteToData.getCurrencyByIdentifier(identifier));
        return roundedFFSupply;

    }

    // Getting total float supply as double from response
    public static double getTotalSupplyAsDouble(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String totalSupply = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("totalSupply");
        // Returning rounded total float supply as a string
        double conversion = Double.parseDouble(totalSupply);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        return rounded;
    }

    // Getting total float supply from response
    public static String getTotalSupply(String identifier) throws Exception {
        double totalSupply = getTotalSupplyAsDouble(identifier);
        String roundedTotalSupply = String.valueOf(totalSupply);
        WriteToData.jumpLine("getTotalSupply " + roundedTotalSupply, WriteToData.getCurrencyByIdentifier(identifier));
        return roundedTotalSupply;

    }

    // Getting marketCap as double from response
    public static double getMarketCapAsDouble(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String marketCap = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("marketCap");
        // Returning rounded marketCap as a string
        double conversion = Double.parseDouble(marketCap);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        return rounded;
    }

    // Getting marketCap from response
    public static String getMarketCap(String identifier) throws Exception {
        double marketCap = getMarketCapAsDouble(identifier);
        String roundedMarketCap = String.valueOf(marketCap);
        WriteToData.jumpLine("getMarketCap " + roundedMarketCap, WriteToData.getCurrencyByIdentifier(identifier));
        return roundedMarketCap;

    }

    // Getting currency daily marketCap change from response
    public static String getMarketCapPercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily marketCap change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("marketCapPercentChange").optString("change24h");
        WriteToData.jumpLine("getDailyMarketCapPercentChange " + dailyPercentage,
                WriteToData.getCurrencyByIdentifier(id));
        return dailyPercentage;

    }

    // Getting currency daily marketCap change from response as a double
    public static double getMarketCapPercentageAsDouble(String id) throws Exception {
        String percentage = getMarketCapPercentage(id);
        double conversion = Double.parseDouble(percentage);
        return conversion;

    }

    // Getting totalMarketCap as double from response
    public static double getTotalMarketCapAsDouble(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String marketCap = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("totalMarketCap");
        // Returning rounded marketCap as a string
        double conversion = Double.parseDouble(marketCap);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        return rounded;
    }

    // Getting totalMarketCap from response
    public static String getTotalMarketCap(String identifier) throws Exception {
        double totalMarketCap = getTotalMarketCapAsDouble(identifier);
        String roundedTotalMarketCap = String.valueOf(totalMarketCap);
        WriteToData.jumpLine("getTotalMarketCap " + roundedTotalMarketCap,
                WriteToData.getCurrencyByIdentifier(identifier));
        return roundedTotalMarketCap;

    }

    // Getting currency daily totalMarketCap change from response
    public static String getTotalMarketCapPercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily totalMarketCap change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("totalMarketCapPercentChange").optString("change24h");
        WriteToData.jumpLine("getDailytotalMarketCapPercentChange " + dailyPercentage,
                WriteToData.getCurrencyByIdentifier(id));
        return dailyPercentage;

    }

    // Getting currency daily totalMarketCap change from response as a double
    public static double getTotalMarketCapPercentageAsDouble(String id) throws Exception {
        String percentage = getTotalMarketCapPercentage(id);
        double conversion = Double.parseDouble(percentage);
        return conversion;

    }

    // Getting volume as double from response
    public static double getVolumeAsDouble(String identifier) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(identifier);
        // Price as stringy
        String volume = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .optString("volume");
        // Returning rounded volume as a string
        double conversion = Double.parseDouble(volume);
        double rounded = Math.round(conversion * 100.0) / 100.0;
        return rounded;
    }

    // Getting volume from response
    public static String getVolume(String identifier) throws Exception {
        double volume = getVolumeAsDouble(identifier);
        String roundedVolume = String.valueOf(volume);
        WriteToData.jumpLine("getVolume " + roundedVolume, WriteToData.getCurrencyByIdentifier(identifier));
        return roundedVolume;

    }

    // Getting currency daily volume change from response
    public static String getVolumePercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily volume change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("volumePercentChange").optString("change24h");
        WriteToData.jumpLine("getVolumePercentage " + dailyPercentage, WriteToData.getCurrencyByIdentifier(id));
        return dailyPercentage;

    }

    // Getting currency daily volume change from response as a double
    public static double getVolumePercentageAsDouble(String id) throws Exception {
        String percentage = getVolumePercentage(id);
        double conversion = Double.parseDouble(percentage);
        return conversion;

    }

}
