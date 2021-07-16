package com.trendo.backend;

public class DataBase {
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
    // This one changes each 24h @getToken at
    // "https://rapidapi.com/BraveNewCoin/api/bravenewcoin?endpoint=apiendpoint_d040b5cb-b6da-4628-bb86-fef663f635dc"
    public static String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik5EVXhNRGhHT0VReE56STVOelJCTTBJM1FrUTVOa0l4TWtRd1FrSTJSalJFTVRaR1F6QTBOZyJ9.eyJpc3MiOiJodHRwczovL2F1dGguYnJhdmVuZXdjb2luLmNvbS8iLCJzdWIiOiJvQ2RRb1pvSTk2RVJFOUhZM3NRN0ptYkFDZkJmNTVSWUBjbGllbnRzIiwiYXVkIjoiaHR0cHM6Ly9hcGkuYnJhdmVuZXdjb2luLmNvbSIsImlhdCI6MTYyNjQyMDIyNSwiZXhwIjoxNjI2NTA2NjI1LCJhenAiOiJvQ2RRb1pvSTk2RVJFOUhZM3NRN0ptYkFDZkJmNTVSWSIsInNjb3BlIjoicmVhZDppbmRleC10aWNrZXIgcmVhZDpyYW5raW5nIHJlYWQ6bXdhIHJlYWQ6Z3dhIHJlYWQ6YWdncmVnYXRlcyByZWFkOm1hcmtldCByZWFkOmFzc2V0IHJlYWQ6b2hsY3YgcmVhZDptYXJrZXQtY2FwIiwiZ3R5IjoiY2xpZW50LWNyZWRlbnRpYWxzIn0.bVNqxKQShTaGD4N1Bu9-2cRVjBkyPhcbhqmjQUbhPurbMEtrqQ-xfJFPdc0kTpYJgM1nhCovq3Nc9YKnqPm7JVtiPt2K5mHDcFZmDo82k6BKhOparKp3ub-qeS96IfnWBSbC_sUtLjIRm6IhMpb-N1jVzTBsmRjCpq1dxHdhjZBEN6jzs39FjEgt03MUFQYu52NmjeueqHnEGMaqJnVKqgzDL5ZgLrN-snnuXzmy7gApuAwVsW3II4ZEqcSsXD8ydVOVmXn8zmQdBk78NKjw-GtgJEAWuIuVXzQiaw2s61JqTOqwGEg1IsYlZFj_NdMybkWpuFezrM4tMJ1jawePgg";

    // currencies names for TweetCount
    public static String eth = " ETH ";
    public static String doge = " DOGE ";
    public static String bnb = " BNB ";
    public static String link = " chainlink ";
    public static String eos = " EOS ";
    // day index for tweets weekObject
    public static int yesterday = 6;
    public static int twoDaysAgo = 5;
    // filepath to write data in
    public static String filepath = "C:\\Users\\samya\\OneDrive\\Bureau\\Github\\trendo_web\\DataStorage\\";

}
