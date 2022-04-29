package aoc.day02;

import aoc.Day;

import java.util.List;

public class Day02 implements Day {
    @Override
    public String part1(List<String> input) {
        int horizontal = 0;
        int depth = 0;

        for(int i = 0; i < input.size(); i++) {
            String[] actions = input.get(i).split(" ");

            String type = actions[0];
            int value = Integer.parseInt(actions[1]);

            switch(type) {
                case "forward":
                    horizontal += value;
                    break;
                case "up":
                    depth -= value;
                    break;
                case "down":
                    depth += value;
                    break;
                default:
                    break;
            }
        }

        return Integer.toString(depth * horizontal);
    }

    @Override
    public String part2(List<String> input) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for(int i = 0; i < input.size(); i++) {
            String[] actions = input.get(i).split(" ");

            String type = actions[0];
            int value = Integer.parseInt(actions[1]);

            switch(type) {
                case "forward":
                    horizontal += value;
                    depth += value * aim;
                    break;
                case "up":
//                    depth -= value;
                    aim -= value;
                    break;
                case "down":
//                    depth += value;
                    aim += value;
                    break;
                default:
                    break;
            }
        }

        return Integer.toString(depth * horizontal);
    }

}
