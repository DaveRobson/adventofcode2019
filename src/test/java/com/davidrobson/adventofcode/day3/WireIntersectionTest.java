package com.davidrobson.adventofcode.day3;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class WireIntersectionTest {

    @Test
    public void parse() throws Exception {

        String[] rawWires = new String[]{"R75,D30,R83,U83,L12,D49,R71,U7,L72", "L75,D30,R83,U83,L12,D49,R71,U7,L72"};
        WireIntersection intersection = new WireIntersection();

        List<List<Instruction>> wires = intersection.execute(rawWires);
        List<Line> lines = new ArrayList<>();
        for(List<Instruction> wire : wires) {
            lines.add(new Line(wire));
        }

        Grid grid = new Grid(lines);


        FileOutputStream out = new FileOutputStream("C:\\Users\\RobsonD\\Documents\\Developer\\area51\\adventofcode\\grid.txt");

        out.write(grid.drawGrid().getBytes());
        out.close();

    }
}
