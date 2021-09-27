package com.trendo.backend.methods;

//unirest imports
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class getToken {
    public static void main(String[] args) {

    }

    // Returns token as a string
    public static String getTokenAsString() throws Exception {

        HttpResponse<JsonNode> response = Unirest.post("https://bravenewcoin.p.rapidapi.com/oauth/token")
                .header("content-type", "application/json").header("x-rapidapi-host", "bravenewcoin.p.rapidapi.com")
                .header("x-rapidapi-key", "5dcc767e21msh6eb86612ad393aep192d68jsn24088a077eae")
                .body("{\r \"audience\": \"https://api.bravenewcoin.com\",\r\"client_id\": \"oCdQoZoI96ERE9HY3sQ7JmbACfBf55RY\", \r \"grant_type\": \"client_credentials\"\r }")
                .asJson();
        String token = response.getBody().getArray().getJSONObject(0).opt("access_token").toString();
        return token;

    }
}
