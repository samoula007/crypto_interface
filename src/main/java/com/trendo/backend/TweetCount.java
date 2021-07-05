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

    // takes the number of yesterday's tweets from getWeekObject
    public static String getTweetCountStringYesterday(String currency) throws IOException, URISyntaxException {
        String bearerToken = BearerToken.token; // you will need your own twitter bearer token
        String response = getWeekObject(currency, bearerToken);
        JSONObject jsnobject = new JSONObject(response);
        String yesterdayTweets = jsnobject.optJSONArray("data").getJSONObject(6).optString("tweet_count");

        return yesterdayTweets;
    }

    // takes the number of two days ago tweets from getWeekObject
    public static String getTweetCountStringTwoDaysAgo(String currency) throws IOException, URISyntaxException {
        String bearerToken = BearerToken.token; // you will need your own twitter bearer token
        String response = getWeekObject(currency, bearerToken);
        JSONObject jsnobject = new JSONObject(response);
        String yesterdayTweets = jsnobject.optJSONArray("data").getJSONObject(5).optString("tweet_count");

        return yesterdayTweets;
    }

    // converts the number of tweets from yesterday to an integer
    public static int getTweetCountIntYesterday(String currency) throws IOException, URISyntaxException {
        String number = getTweetCountStringYesterday(currency);
        int asInt = Integer.parseInt(number);

        return asInt;
    }

    // converts the number of tweets from two days ago to an integer
    public static int getTweetCountIntTwoDaysAgo(String currency) throws IOException, URISyntaxException {
        String number = getTweetCountStringTwoDaysAgo(currency);
        int asInt = Integer.parseInt(number);

        return asInt;
    }

    // gets the percent of variation of the number of tweets
    // between two days ago and yesterday
    public static String getTweetsPercentChange(String currency) throws IOException, URISyntaxException {
        int twoDaysAgo = getTweetCountIntTwoDaysAgo(currency);
        int yesterday = getTweetCountIntYesterday(currency);

        if (twoDaysAgo < yesterday) { // increase
            double subtraction = yesterday - twoDaysAgo;
            double percent = subtraction * 100 / twoDaysAgo;
            double rounded = Math.round(percent * 100.0) / 100.0;
            String roundedPercentChange = "+" + String.valueOf(rounded);
            return roundedPercentChange;
        } else if (twoDaysAgo == yesterday) { // no change
            String percentChange = "0.00";
            return percentChange;
        } else { // decrease
            double subtraction = twoDaysAgo - yesterday;
            double percent = subtraction * 100 / twoDaysAgo;
            double rounded = Math.round(percent * 100.0) / 100.0;
            String roundedPercentChange = "-" + String.valueOf(rounded);
            return roundedPercentChange;

        }

    }
}
