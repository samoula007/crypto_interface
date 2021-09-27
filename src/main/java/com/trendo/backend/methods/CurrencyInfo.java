package com.trendo.backend.methods;
//eventually rotate towards the yahoo finance api. Can make 100 calls a day, so make sure to be efficient.

//unirest imports
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class CurrencyInfo {

    // Returning the response object to use in other functions
    public static HttpResponse<JsonNode> createResponse(String id) throws Exception {
        //Getting a new token from BraveNewCoin API
        DataBase db = new DataBase();
        String token = db.getToken();

        // Requesting response and returning it
        HttpResponse<JsonNode> response = Unirest.get(DataBase.host + id + DataBase.percentage)
                .header("authorization", "Bearer " + token).header("x-rapidapi-key", DataBase.apiKey)
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(id), "pricePercentChange", dailyPercentage,
                WriteToData.getDate());
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(identifier), "price", roundedPrice,
                WriteToData.getDate());
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(identifier), "freeFloatSupply",
                roundedFFSupply, WriteToData.getDate());
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(identifier), "totalSupply",
                roundedTotalSupply, WriteToData.getDate());
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(identifier), "marketCap", roundedMarketCap,
                WriteToData.getDate());
        return roundedMarketCap;

    }

    // Getting currency daily marketCap change from response
    public static String getMarketCapPercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily marketCap change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("marketCapPercentChange").optString("change24h");
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(id), "marketCapPercentChange",
                dailyPercentage, WriteToData.getDate());
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(identifier), "totalMarketCap",
                roundedTotalMarketCap, WriteToData.getDate());
        return roundedTotalMarketCap;

    }

    // Getting currency daily totalMarketCap change from response
    public static String getTotalMarketCapPercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily totalMarketCap change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("totalMarketCapPercentChange").optString("change24h");
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(id), "totalMarketCapPercentChange",
                dailyPercentage, WriteToData.getDate());
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
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(identifier), "volume", roundedVolume,
                WriteToData.getDate());
        return roundedVolume;

    }

    // Getting currency daily volume change from response
    public static String getVolumePercentage(String id) throws Exception {
        // creating response
        HttpResponse<JsonNode> response = createResponse(id);
        // Daily volume change as string
        String dailyPercentage = response.getBody().getArray().getJSONObject(0).optJSONArray("content").getJSONObject(0)
                .getJSONObject("volumePercentChange").optString("change24h");
        // write data to MongoDB
        WriteToData.connectionToMongodb(WriteToData.getCurrencyByIdentifier(id), "volumePercentChange", dailyPercentage,
                WriteToData.getDate());
        return dailyPercentage;

    }

    // Getting currency daily volume change from response as a double
    public static double getVolumePercentageAsDouble(String id) throws Exception {
        String percentage = getVolumePercentage(id);
        double conversion = Double.parseDouble(percentage);
        return conversion;

    }

}
