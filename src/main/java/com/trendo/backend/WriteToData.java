package com.trendo.backend;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

//Data writer and some utilities
public class WriteToData {

    public void main(String[] args) {

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
    private static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

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
