package com.davidrobson.adventofcode.day2;


import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class Intcode {
    Intcode() {
    }

    Integer execute(int noun, int verb) throws Exception {
        final String input = loadFile();
        final Integer[] state = parseArray(input.split(","));
        state[1] = noun;
        state[2] = verb;

        final Integer[] programState = executor(state, 0);
        return programState[0];
    }

    private Integer[] executor(Integer[] state, int position) throws Exception {
        Integer first = state[position];

        if(99 == first) {
            return state;
        }

        int argument1 = state[state[position + 1]];
        int argument2 = state[state[position + 2]];
        int mutationPosition = state[position + 3];

        int result;

        if(1 == first) {
            result = argument1 + argument2;
        } else if (2 == first) {
            result = argument1 * argument2;
        } else {
            throw new Exception("Unknown operation " + first);
        }

        state[mutationPosition] = result;
        return executor(state, position + 4);
    }

    private String loadFile() throws IOException {
        final InputStream inputStream = Intcode.class.getClassLoader().getResourceAsStream("intcode_input.txt");
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    private Integer[] parseArray(String[] inputs) {
        Integer[] ints = new Integer[inputs.length];
        for(int i = 0; i < inputs.length; i++) {
            ints[i] = Integer.parseInt(inputs[i].replace("\n", "").replace("\r", ""));
        }

        return ints;
    }
}
