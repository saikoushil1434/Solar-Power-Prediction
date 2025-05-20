package com.solarprediction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/solar_data.csv"; 
        List<solarData> dataList = CSVReader.readCSV(filePath);

        LinearRegressionModel model = new LinearRegressionModel();
        model.trainModel(dataList);

        double prediction = model.predict(400);
        System.out.println("Predicted Power Output for 400 Solar Radiation: " + prediction);
    }
}
