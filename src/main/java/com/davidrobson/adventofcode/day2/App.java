package com.davidrobson.adventofcode.day2;

public class App {
    public static void main(String[] args) throws Exception {
        final Intcode program = new Intcode();

        int noun = 0;

        int answer = 19690720;

        outerloop:
        while(noun <= 99) {
            int verb = 0;
            while(verb <= 99) {
                int result = program.execute(noun, verb);
                if(result == answer) {
                    System.out.println("result: " + result + " verb: " + verb + " noun " + noun);
                    break outerloop;
                }
                verb++;
            }
            noun++;
        }
    }

}
