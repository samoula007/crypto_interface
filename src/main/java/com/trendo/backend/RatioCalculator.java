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
        return stringedRatio;
    }

}
