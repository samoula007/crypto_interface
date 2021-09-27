package com.trendo.backend.methods;

;

//Any data useful for the methods.
//The bravenewcoin api requires to change your token each 24h
//If you want to add a new currency to track:
//add its uuid from the BraveNewCoin api
//add the tweet tag you want to count with the twitter api
//call the methods on these newly added data
//modify the frontend to use these new data
public class DataBase {

    private String token;

    // to resolve Exception
    public DataBase() throws Exception {
        this.token = getToken.getTokenAsString();
    }

    public String getToken() {
        return token;
    }

    // currencies identifiers for CurrenciesPrice
    public static String uuidETH = "e991ba77-d384-48ff-b0a4-40e95ef6b7d6";
    public static String uuidDOGE = "7bb2339e-b6eb-408c-836f-2894c8751c6d";
    public static String uuidBNB = "9ffe8a9d-16bc-42a7-9b12-1a41d766c590";
    public static String uuidLINK = "bf5421f5-59ea-4e90-914b-da89e384df37";
    public static String uuidEOS = "ab8ac321-082b-4231-a31c-4c938cfceab7";
    // currencies api keys
    // General Variables for api
    public static String apiKey = "5dcc767e21msh6eb86612ad393aep192d68jsn24088a077eae";
    public static String apiHost = "bravenewcoin.p.rapidapi.com";
    public static String host = "https://bravenewcoin.p.rapidapi.com/market-cap?assetId=";
    public static String percentage = "&percentChange=true";

    // currencies names for TweetCount
    public static String eth = "ETH";
    public static String doge = "DOGE";
    public static String bnb = "BNB";
    public static String link = "chainlink";
    public static String eos = "EOS";
    // day index for tweets weekObject
    public static int yesterday = 6;
    public static int twoDaysAgo = 5;
    // filepath to write data in
    public static String filepath = "C:\\Users\\samya\\OneDrive\\Bureau\\Github\\trendo_web\\DataStorage\\";
    public static String mongoDBConnectionString = "mongodb+srv://github:github@cluster0.ihppp.mongodb.net/Mugiwara?retryWrites=true&w=majority";
}
