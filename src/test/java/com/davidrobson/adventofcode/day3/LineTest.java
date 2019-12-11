package com.davidrobson.adventofcode.day3;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LineTest {
    @Test
    public void distance18() throws Exception {
        List<Instruction> instructions = Lists.newArrayList(
                new Instruction("R", 8),
                new Instruction("U", 5),
                new Instruction("L", 5),
                new Instruction("D", 3));

        Line line150 = new Line(instructions);
        Coordinate xy = new Coordinate(3, -5);

        int index = line150.getState().indexOf(xy);
        int steps = index + 1;

        assertEquals(steps, index);
    }


    @Test
    public void distance123() throws Exception {
        List<Instruction> instructions = Lists.newArrayList(
            Instruction.of("R", 75),
            Instruction.of("D", 30),
            Instruction.of("R", 83),
            Instruction.of("U", 83),
            Instruction.of("L", 12),
            Instruction.of("D", 49),
            Instruction.of("R", 71),
            Instruction.of("U", 7),
            Instruction.of("L", 72)
                );

        Line line = new Line(instructions);

        Coordinate xy = new Coordinate(3, -5);

        int index = line.getState().indexOf(xy);
    }
}
