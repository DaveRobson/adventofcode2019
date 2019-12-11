package com.davidrobson.adventofcode.day3;

import com.sun.corba.se.spi.transport.CorbaAcceptor;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Coordinate> state;
    private List<Line> lines;

    public Grid(List<Line> lines) {
        this.state = new ArrayList<>();
        this.lines = lines;
    }

    public List<Coordinate> intersection() {
        List<Coordinate> interset = new ArrayList<>();

        for(Coordinate coordinate : lines.get(0).getState()) {
            for(Coordinate innerCoordinate : lines.get(1).getState()) {
                if(coordinate.equals(innerCoordinate) && !coordinate.equals(new Coordinate(0,0))) {
                    interset.add(coordinate);
                    System.out.println(coordinate.getX() + ", " + coordinate.getY());
                }
            }
        }

        return interset;
    }

    public String drawGrid() {
        int up = 0;
        int right = 0;
        int left = 0;
        int down = 0;

        for(Line line : lines) {
            up += line.getMaxUp();
            right += line.getMaxRight();
            down += line.getMaxDown();
            left += line.getMaxLeft();
        }

        int[][] gridRef = new int[up + down][left + right];
        final Coordinate startPoint = new Coordinate((left + right) / 2, (up + down) / 2);

        lines.forEach(l -> drawLine(gridRef, l, startPoint));

        return gridtoString(gridRef);
    }

    public void drawLine(int[][] gridRef, Line line, Coordinate startPoint) {
        for(Coordinate coordinate : line.getState()) {
            gridRef[coordinate.getY() +  startPoint.getY()][coordinate.getX() + startPoint.getX()] = 1;
        }
    }

    public String gridtoString(int[][] gridRef) {
        StringBuilder rowBuilder = new StringBuilder();
        for(int[] row : gridRef) {
            StringBuilder cellBuilder = new StringBuilder();
            for(int cell : row) {
                cellBuilder.append(cell);
            }
            rowBuilder.append(cellBuilder.toString()).append(System.lineSeparator());
        }

        return rowBuilder.toString();
    }

    public List<Coordinate> getState() {
        return state;
    }



}
