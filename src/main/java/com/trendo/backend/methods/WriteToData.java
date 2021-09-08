package com.trendo.backend.methods;

import java.io.*;
import java.time.format.DateTimeFormatter;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDateTime;

//Data writer and some utilities
public class WriteToData {

    public void main(String[] args) {

    }

    public static void connectionToMongodb(String databasename, String collection, String value, String date) {
        ConnectionString connectionString = new ConnectionString(DataBase.mongoDBConnectionString);
        MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        // closes the connection after the try block
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            // create new data object in proper database/collection
            MongoDatabase database = mongoClient.getDatabase(databasename);
            Document doc = new Document();
            doc.put("day", getDay(date));
            doc.put("timestamp", getTimestamp(date));
            doc.put("value", value);

            database.getCollection(collection).insertOne(doc);
        }
    }

    // Appends data on same line
    public static void writer(String input, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.filepath + path, true));
            bw.write(input + " date " + getDate());
            bw.close();
        } catch (Exception ex) {
            return;
        }
    }

    // Appends data on newline
    public static void jumpLine(String input, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.filepath + path.trim(), true));
            bw.write(input + "***" + getDate() + "\n");
            bw.close();
        } catch (Exception ex) {
            return;
        }
    }

    // Returns the date and time
    public static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

    public static String getDay(String date) {
        String[] strArray = date.split(" ");
        return strArray[0];
    }

    public static String getTimestamp(String date) {
        String[] strArray = date.split(" ");
        return strArray[1];

    }
    // Returns currency tag from identifier
    public static String getCurrencyByIdentifier(String identifier) {
        if (identifier.equals(DataBase.uuidETH)) {
            return "ETH";
        } else if (identifier.equals(DataBase.uuidDOGE)) {
            return "DOGE";
        } else if (identifier.equals(DataBase.uuidBNB)) {
            return "BNB";
        } else if (identifier.equals(DataBase.uuidLINK)) {
            return "LINK";
        } else if (identifier.equals(DataBase.uuidEOS)) {
            return "EOS";
        }
        return "Unknown";
    }

}
