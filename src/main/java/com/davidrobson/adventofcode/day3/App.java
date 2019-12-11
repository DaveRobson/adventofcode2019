package com.davidrobson.adventofcode.day3;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        final String[] rawWires = loadFile().split(System.lineSeparator());
        //final String[] rawWires = new String[] {"R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83"};

        WireIntersection wireIntersection = new WireIntersection();

        List<List<Instruction>> wires = wireIntersection.execute(rawWires);
        List<Line> lines = new ArrayList<>();
        for(List<Instruction> wire : wires) {
            lines.add(new Line(wire));
        }
        Grid grid = new Grid(lines);

        List<Coordinate> intersection = grid.intersection();

        System.out.println(manhattenDistance(intersection));
        System.out.println(shortestPath(lines, intersection));

//        FileOutputStream out = new FileOutputStream("C:\\Users\\RobsonD\\Documents\\Developer\\area51\\adventofcode\\grid.txt");
//
//        out.write(grid.drawGrid().getBytes());
//        out.close();
    }

    private static int shortestPath(List<Line> lines, List<Coordinate> intersection) {
        final Map<Coordinate, Integer> matched = new HashMap<>();

        for(Line line : lines) {
            List<Coordinate> state = line.getState();

            for(Coordinate coordinate : intersection) {
                int index = state.indexOf(coordinate);
                int steps = index + 1;
                Coordinate match = state.get(index);
                if(matched.containsKey(match)) {
                    int value = matched.get(match);
                    matched.put(match, value + steps);
                } else {
                    matched.put(match, steps);
                }
            }
        }

        Optional<Integer> first = matched.values().stream().sorted().findFirst();
        return first.get();
    }

    private static int manhattenDistance(List<Coordinate> coordinates) {
       List<Coordinate> sorted = coordinates.stream()
               .sorted(App::compare)
               .collect(Collectors.toList());
        Coordinate closest = sorted.get(0);
        System.out.println(closest.getY() + ", " + closest.getX());
        return Math.abs(closest.getY()) + Math.abs(closest.getX());
    }

    private static int compare(Coordinate c1, Coordinate c2) {
        return (Math.abs(c1.getY()) + Math.abs(c1.getX())) - (Math.abs(c2.getY()) + Math.abs(c2.getX()));
    }

    private static String loadFile() throws IOException {
        final InputStream inputStream = App.class.getClassLoader().getResourceAsStream("wires_input.txt");
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }
}

