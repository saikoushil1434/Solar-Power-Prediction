package com.solarprediction;

import java.io.*;

import java.util.*;

public class CSVReader {
    public static List<solarData> readCSV(String filePath) {
        List<solarData> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                dataList.add(new solarData(Double.parseDouble(values[0]), Double.parseDouble(values[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
