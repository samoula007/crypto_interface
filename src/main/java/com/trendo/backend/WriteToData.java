package com.trendo.backend;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

//Je dois append les datas au file, pas overwrite
//je dois logger le temps et l'heure a coter du logged data
//je dois logger le nom de la data
//je jumpline a chaque entree de data
//quand je dois creer une autre methode qui va lire du data file et regrouper les donnes pour le graph
public class WriteToData {

    public void main(String[] args) {

    }

    public static void writer(String input, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.filepath + path, true));
            bw.write(input + " date " + getDate());
            bw.close();
        } catch (Exception ex) {
            return;
        }
    }

    public static void jumpLine(String input, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.filepath + path.trim(), true));
            bw.write(input + "***" + getDate() + "\n");
            bw.close();
        } catch (Exception ex) {
            return;
        }
    }

    private static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }

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
