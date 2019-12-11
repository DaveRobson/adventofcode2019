package com.davidrobson.adventofcode.day1;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class FuelCalculator {

    FuelCalculator() throws IOException {
        String[] masses = loadFile().split(System.lineSeparator());
        double total = 0;

        for(String moduleMass : masses) {
            double moduleFuel = calculation(Double.parseDouble(moduleMass));
            double fuelMass = moduleFuel;

            while(calculation(fuelMass) > 0) {
                double fuelCal = calculation(fuelMass);
                moduleFuel += fuelCal;
                fuelMass = fuelCal;
            }
            total += moduleFuel;
        }

        System.out.println(total);
    }

    private double calculation(double mass) {
        final double dividedMass = mass / 3;
        final double roundDown = Math.floor(dividedMass);
        return roundDown - 2;
    }

    private String loadFile() throws IOException {
        final InputStream inputStream = FuelCalculator.class.getClassLoader().getResourceAsStream("input.txt");
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }
}
