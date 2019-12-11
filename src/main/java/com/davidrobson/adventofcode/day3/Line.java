package com.davidrobson.adventofcode.day3;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Coordinate> state;
    private int maxRight = 0;
    private int maxLeft = 0;
    private int maxUp = 0;
    private int maxDown = 0;

    public Line(List<Instruction> instructions) throws Exception {
        state = new ArrayList<>();
        Coordinate currentPosition = new Coordinate(0, 0);
        for(Instruction instruction : instructions) {
           currentPosition = move(instruction, currentPosition);
        }
    }

    public Coordinate move(Instruction instruction, Coordinate startPosition) throws Exception {
        String direction = instruction.getDirection();
        int distance = instruction.getDistance();

        switch(direction) {
            case "R":
                return right(startPosition, distance);
            case "L":
                return left(startPosition, distance);
            case "U":
                return down(startPosition, distance);
            case "D":
                return up(startPosition, distance);
            default:
                throw new Exception("Unknown type: " + direction);
        }
    }

    private Coordinate down(Coordinate currentPosition, int distance) {
        maxDown += distance;
        int y = currentPosition.getY() - 1;
        int startPoint = currentPosition.getY() - distance;

        for(int i = y; i >= startPoint; i--) {
            state.add(new Coordinate(currentPosition.getX(), i));
        }

        return new Coordinate(currentPosition.getX(), startPoint);
    }

    private Coordinate up(Coordinate currentPosition, int distance) {
        maxUp += distance;
        int y = currentPosition.getY() + 1;
        int endPoint = currentPosition.getY() + distance;

        for(int i = y; i <= endPoint; i++) {
            state.add(new Coordinate(currentPosition.getX(), i));
        }

        return new Coordinate(currentPosition.getX(), endPoint);
    }

    private Coordinate left(Coordinate currentPosition, int distance) {
        maxLeft += distance;
        int x = currentPosition.getX() - 1;
        int startPoint = currentPosition.getX() - distance;

        for(int i = x; i >= startPoint; i--) {
            state.add(new Coordinate(i, currentPosition.getY()));
        }

        return new Coordinate(startPoint, currentPosition.getY());
    }

    private Coordinate right(Coordinate currentPosition, int distance) {
        maxRight += distance;
        int x = currentPosition.getX() + 1;
        int endPoint = currentPosition.getX() + distance;

        for(int i = x; i <= endPoint; i++) {
            state.add(new Coordinate(i, currentPosition.getY()));
        }

        return new Coordinate(endPoint, currentPosition.getY());
    }

    public List<Coordinate> getState() {
        return state;
    }

    public int getMaxRight() {
        return maxRight;
    }

    public int getMaxLeft() {
        return maxLeft;
    }

    public int getMaxUp() {
        return maxUp;
    }

    public int getMaxDown() {
        return maxDown;
    }

}
