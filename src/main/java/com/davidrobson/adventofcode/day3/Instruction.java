package com.davidrobson.adventofcode.day3;

public class Instruction {

    private String direction;
    private Integer distance;

    public Instruction(String direction, Integer distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public static Instruction of(String direction, Integer distance) {
        return new Instruction(direction, distance);
    }

    public String getDirection() {
        return direction;
    }

    public Integer getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "direction='" + direction + '\'' +
                ", distance=" + distance +
                '}';
    }
}
