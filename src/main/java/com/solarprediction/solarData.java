package com.solarprediction;

public class solarData {  
    private double radiation;
    private double powerOutput;

    public solarData(double radiation, double powerOutput) {  
        this.radiation = radiation;
        this.powerOutput = powerOutput;  
    }

    public double getRadiation() {
        return radiation;
    }

    public double getPowerOutput() {
        return powerOutput;
    }
}
