package com.solarprediction;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Your React frontend origin
public class predictionController {

    private final LinearRegressionModel model;

    public predictionController() {
        model = new LinearRegressionModel();
        List<solarData> trainingData = CSVReader.readCSV("src/main/resources/solar_data.csv");
        model.trainModel(trainingData);
    }

    @PostMapping("/predict")
    public Map<String, Double> predict(@RequestBody solarData input) {
        double output = model.predict(input);
        return Collections.singletonMap("powerOutput", output);
    }
}
