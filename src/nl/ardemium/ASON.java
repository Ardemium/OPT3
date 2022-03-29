package nl.ardemium;

import java.io.*;
import java.util.ArrayList;

public class ASON {
    private static void makeValue(String key, String value, String database) {
        try {
            File file = new File("ASON");
            file.mkdir();
            FileWriter fileWriter = new FileWriter("ASON/" + database, true);
            fileWriter.append(String.format("\"%s\":\"%s\",%n", key, value));
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeObject(String database) {
        try {
            File file = new File("ASON");
            file.mkdir();
            FileWriter fileWriter = new FileWriter("ASON/" + database, true);
            fileWriter.append(String.format("%n"));
            fileWriter.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeObject(String key1, String value1, String key2, String value2, String key3, String value3, String database) {
        makeValue(key1, value1, database);
        makeValue(key2, value2, database);
        makeValue(key3, value3, database);
        closeObject(database);
    }

    public static ArrayList<String> stripValue(String key, String database) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader bufferdReader = new BufferedReader(new FileReader("ASON/" + database));
            String line = bufferdReader.readLine();

            while (line != null) {
                if (line.contains(key)) {
                    String[] extraction = line.split(":");
                    extraction = extraction[1].split("\"");
                    list.add(extraction[1]);
                }
                line = bufferdReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void clearDatabase(String database) {
        try {
            FileWriter fileWriter = new FileWriter("ASON/" + database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}