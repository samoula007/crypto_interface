package com.trendo.backend;

public class RatioCalculator {

    public void main(String[] args) {
    }

    public static String getRatio(String identifier, String currency) throws Exception {
        double pricePercentageNow = CurrenciesPrice.getDailyPercentageAsDouble(identifier);
        double tweetsPercentageYesterday = TweetCount.getTweetsPercentChangeAsDouble(currency);
        double ratio = pricePercentageNow / tweetsPercentageYesterday;
        double rounded = Math.round(ratio * 100.0) / 100.0;
        String stringedRatio = String.valueOf(rounded);
        if (currency.equals(DataBase.link)) {
            currency = "LINK";
        }
        WriteToData.jumpLine("getRatio " + stringedRatio, WriteToData.getCurrencyByIdentifier(identifier));
        return stringedRatio;
    }

    public static String getSentiment(String identifier, String currency) throws Exception {
        double pricePercentageNow = CurrenciesPrice.getDailyPercentageAsDouble(identifier);
        double tweetsPercentageYesterday = TweetCount.getTweetsPercentChangeAsDouble(currency);
        String sentiment;
        if (pricePercentageNow < 0) {
            if (tweetsPercentageYesterday < 0) {
                sentiment = "negative";
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                WriteToData.jumpLine("getSentiment " + sentiment, currency);
                return sentiment;
            }
            sentiment = "positive";
            if (currency.equals(DataBase.link)) {
                currency = "LINK";
            }
            WriteToData.jumpLine("getSentiment " + sentiment, currency);
            return sentiment;
        } else {
            if (tweetsPercentageYesterday >= 0) {
                sentiment = "darkskin";
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                WriteToData.jumpLine("getSentiment " + sentiment, currency);
                return sentiment;
            }
            sentiment = "lightskin";
            if (currency.equals(DataBase.link)) {
                currency = "LINK";
            }
            WriteToData.jumpLine("getSentiment " + sentiment, currency);
            return sentiment;
        }

    }
}
