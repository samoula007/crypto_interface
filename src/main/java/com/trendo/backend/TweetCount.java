package com.trendo.backend;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TweetCount {

    public void main(String[] args) throws IOException, URISyntaxException {

    }

    // gets the prices of the week as a string
    private static String getWeekObject(String searchString, String bearerToken)
            throws IOException, URISyntaxException {
        String searchResponse = null;

        HttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build()).build();

        URIBuilder uriBuilder = new URIBuilder("https://api.twitter.com/2/tweets/counts/recent");
        ArrayList<NameValuePair> queryParameters;
        queryParameters = new ArrayList<>();
        queryParameters.add(new BasicNameValuePair("query", searchString));
        queryParameters.add(new BasicNameValuePair("granularity", "day"));
        uriBuilder.addParameters(queryParameters);

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Authorization", String.format("Bearer %s", bearerToken));
        httpGet.setHeader("Content-Type", "application/json");

        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (null != entity) {
            searchResponse = EntityUtils.toString(entity, "UTF-8");
        }

        return searchResponse;

    }

    public static String getTweetCountString(String currency, int day) throws IOException, URISyntaxException {
        String bearerToken = BearerToken.token; // you will need your own twitter bearer token
        String response = getWeekObject(currency, bearerToken);
        JSONObject jsnobject = new JSONObject(response);
        String yesterdayTweets = jsnobject.optJSONArray("data").getJSONObject(day).optString("tweet_count");

        return yesterdayTweets;
    }

    public static double getTweetCountDouble(String currency, int day) throws IOException, URISyntaxException {
        String number = getTweetCountString(currency, day);
        double asDouble = Double.parseDouble(number);

        return asDouble;
    }

    // gets the percent of variation of the number of tweets
    // between two days ago and yesterday
    public static String getTweetsPercentChange(String currency) throws IOException, URISyntaxException {
        double TweetsTwoDaysAgo = getTweetCountDouble(currency, DataBase.twoDaysAgo);
        double TweetsYesterday = getTweetCountDouble(currency, DataBase.yesterday);

        if (TweetsTwoDaysAgo < TweetsYesterday) { // increase
            double subtraction = TweetsYesterday - TweetsTwoDaysAgo;
            double percent = subtraction * 100 / TweetsTwoDaysAgo;
            double rounded = Math.round(percent * 100.0) / 100.0;
            String roundedPercentChange = String.valueOf(rounded);
            return roundedPercentChange;
        } else if (TweetsTwoDaysAgo == TweetsYesterday) { // no change
            String percentChange = "0.00";
            return percentChange;
        } else { // decrease
            double subtraction = TweetsTwoDaysAgo - TweetsYesterday;
            double percent = subtraction * 100 / TweetsTwoDaysAgo;
            double rounded = Math.round(percent * 100.0) / 100.0;
            String roundedPercentChange = "-" + String.valueOf(rounded);
            return roundedPercentChange;

        }

    }

    public static double getTweetsPercentChangeAsDouble(String currency) throws IOException, URISyntaxException {
        String percentage = getTweetsPercentChange(currency);
        double conversion = Double.parseDouble(percentage);
        return conversion;
    }

}
