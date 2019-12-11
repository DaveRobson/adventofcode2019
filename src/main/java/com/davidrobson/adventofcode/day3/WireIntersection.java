package com.davidrobson.adventofcode.day3;

import java.util.ArrayList;
import java.util.List;

public class WireIntersection {

    public WireIntersection() {

    }

    public List<List<Instruction>> execute(String[] rawWires) {
        return parseRawWires(rawWires);
    }

    private List<List<Instruction>> parseRawWires(String[] rawWires) {
        List<List<Instruction>> wires = new ArrayList<>();

        for (String line : rawWires) {
            String[] rawInstructions = line.split(",");
            wires.add(parseRawInstructions(rawInstructions));
        }

        return wires;
    }

    private List<Instruction> parseRawInstructions(String[] rawInstructions) {
        List<Instruction> instructions = new ArrayList<>();

        for(String rawInstruction : rawInstructions) {
            String direction = rawInstruction.substring(0, 1);
            Integer distance = Integer.parseInt(rawInstruction.substring(1));
            instructions.add(new Instruction(direction, distance));
        }

        return instructions;
    }
}
