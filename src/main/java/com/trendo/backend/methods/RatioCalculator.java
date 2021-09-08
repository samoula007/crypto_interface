package com.trendo.backend.methods;

public class RatioCalculator {

    public void main(String[] args) {
    }

    // returns the ratio of the %PriceChange over %TweetsChange
    public static String getRatio(String identifier, String currency) throws Exception {
        double pricePercentageNow = CurrencyInfo.getDailyPercentageAsDouble(identifier);
        double tweetsPercentageYesterday = TweetCount.getTweetsPercentChangeAsDouble(currency);
        if (pricePercentageNow == 0 || tweetsPercentageYesterday == 0) {
            return "N/A"; // to avoid division by zero
        }
        double ratio = pricePercentageNow / tweetsPercentageYesterday;
        double rounded = Math.round(ratio * 100.0) / 100.0;
        String stringedRatio = String.valueOf(rounded);
        if (currency.equals(DataBase.link)) {
            currency = "LINK";
        }
        // write data to MongoDB
        WriteToData.connectionToMongodb(currency, "Ratio", stringedRatio, WriteToData.getDate());
        return stringedRatio;
    }

    // returns the (experimental) sentiment about a currency
    public static String getSentiment(String identifier, String currency) throws Exception {
        double pricePercentageNow = CurrencyInfo.getDailyPercentageAsDouble(identifier);
        double tweetsPercentageYesterday = TweetCount.getTweetsPercentChangeAsDouble(currency);
        String sentiment;
        if (pricePercentageNow < 0) {
            if (tweetsPercentageYesterday < 0) {
                sentiment = "negative";
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                // write data to MongoDB
                WriteToData.connectionToMongodb(currency, "Sentiment", sentiment, WriteToData.getDate());
                return sentiment;
            }
            sentiment = "positive";
            if (currency.equals(DataBase.link)) {
                currency = "LINK";
            }
            // write data to MongoDB
            WriteToData.connectionToMongodb(currency, "Sentiment", sentiment, WriteToData.getDate());
            return sentiment;
        } else { // includes cases in which the tweet entity is null, meaning it is the default
                 // sentiment
            if (tweetsPercentageYesterday >= 0) {
                sentiment = "darkskin";
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                // write data to MongoDB
                WriteToData.connectionToMongodb(currency, "Sentiment", sentiment, WriteToData.getDate());
                return sentiment;
            }
            sentiment = "lightskin";
            if (currency.equals(DataBase.link)) {
                currency = "LINK";
            }
            // write data to MongoDB
            WriteToData.connectionToMongodb(currency, "Sentiment", sentiment, WriteToData.getDate());
            return sentiment;
        }

    }
}
