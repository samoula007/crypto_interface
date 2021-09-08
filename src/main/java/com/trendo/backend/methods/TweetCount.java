package com.trendo.backend.methods;

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

//The try catch blocks are used to handle the exceptions when the twitter api does not respond
//because of too many calls in a row. The application will only return price datas in such cases.
//Anything related to tweets won't show up in the application if any exception is caught.
public class TweetCount {

    public void main(String[] args) throws IOException, URISyntaxException {

    }

    // gets the prices of the week as a string
    private static String getWeekObject(String searchString, String bearerToken)
            throws IOException, URISyntaxException, Exception {
        try {
            String searchResponse = null;

            HttpClient httpClient = HttpClients.custom()
                    .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
                    .build();

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
            } else if (null == entity) {// because of a call limit on the api, the response returned might be null
                throw new Exception("Entity is null");
            }

            return searchResponse;
        } catch (Exception exception) {

        }
        return null;

    }

    // gets the number of tweets on a currency from x days ago,
    // day=7 returns today && day=1 returns 7 days ago
    public static String getTweetCountString(String currency, int day)
            throws IOException, URISyntaxException, Exception {
        try {
            // you will need your own twitter bearer token
            String bearerToken = "AAAAAAAAAAAAAAAAAAAAAFv1RAEAAAAA%2F28oBbjZikzt3i8jXO1ebKZcgus%3DPlqgHiuCX5QU1VMcbAmFczvkpirjWg8eiO05IoYC1CgrEuuyuC";
            String response = getWeekObject(currency, bearerToken);
            if (response == null) {// because of a call limit on the api, the response returned might be null
                throw new Exception("Entity is null");
            }
            JSONObject jsnobject = new JSONObject(response);
            String yesterdayTweets = jsnobject.optJSONArray("data").getJSONObject(day).optString("tweet_count");
            if (currency.equals(DataBase.link)) {
                currency = "LINK";
            }
            // write data to mongoDB
            WriteToData.connectionToMongodb(currency, "tweetCount", yesterdayTweets, WriteToData.getDate());
            return yesterdayTweets;
        } catch (Exception e) {

        }
        return null;
    }

    // gets the number of tweets on a currency from x days ago,
    // day=7 returns today && day=1 returns 7 days ago, as a double
    public static double getTweetCountDouble(String currency, int day)
            throws IOException, URISyntaxException, Exception {
        try {
            String number = getTweetCountString(currency, day);
            if (number == null) {// because of a call limit on the api, the response returned might be null
                throw new Exception("Entity is null");
            }
            double asDouble = Double.parseDouble(number);

            return asDouble;
        } catch (Exception e) {

        }
        return 0;
    }

    // gets the percent of variation of the number of tweets
    // between two days ago and yesterday
    public static String getTweetsPercentChange(String currency) throws IOException, URISyntaxException, Exception {
        try {
            double TweetsTwoDaysAgo = getTweetCountDouble(currency, DataBase.twoDaysAgo);
            double TweetsYesterday = getTweetCountDouble(currency, DataBase.yesterday);
            if (TweetsTwoDaysAgo == 0 || TweetsYesterday == 0) {
                // might be because of a call limit on the api or because percentage is 0
                // dividing by 0 is not a good idea
                throw new Exception("Error: TweetsTwoDaysAgo or TweetsYesterday is 0");
            }

            if (TweetsTwoDaysAgo < TweetsYesterday) { // increase
                double subtraction = TweetsYesterday - TweetsTwoDaysAgo;
                double percent = subtraction * 100 / TweetsTwoDaysAgo;
                double rounded = Math.round(percent * 100.0) / 100.0;
                String roundedPercentChange = String.valueOf(rounded);
                // remove if statements
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                // write data to mongoDB
                WriteToData.connectionToMongodb(currency, "tweetPercentChange", roundedPercentChange,
                        WriteToData.getDate());
                return roundedPercentChange;
            } else if (TweetsTwoDaysAgo == TweetsYesterday) { // no change
                String percentChange = "0.00";
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                // write data to mongoDB
                WriteToData.connectionToMongodb(currency, "tweetPercentChange", percentChange, WriteToData.getDate());
                return percentChange;
            } else { // decrease
                double subtraction = TweetsTwoDaysAgo - TweetsYesterday;
                double percent = subtraction * 100 / TweetsTwoDaysAgo;
                double rounded = Math.round(percent * 100.0) / 100.0;
                String roundedPercentChange = "-" + String.valueOf(rounded);
                if (currency.equals(DataBase.link)) {
                    currency = "LINK";
                }
                // write data to mongoDB
                WriteToData.connectionToMongodb(currency, "tweetPercentChange", roundedPercentChange,
                        WriteToData.getDate());
                return roundedPercentChange;

            }
        } catch (Exception e) {

        }
        return null;
    }

    // gets the percent of variation of the number of tweets
    // between two days ago and yesterday, as a double
    public static double getTweetsPercentChangeAsDouble(String currency)
            throws IOException, URISyntaxException, Exception {
        try {
            String percentage = getTweetsPercentChange(currency);
            if (percentage == null) {// because of a call limit on the api, the response returned might be null
                throw new Exception("Entity is null");
            }
            double conversion = Double.parseDouble(percentage);
            return conversion;
        } catch (Exception e) {

        }
        return 0;
    }
}