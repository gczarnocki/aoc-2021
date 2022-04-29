package aoc.day01;

import aoc.Day;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day01 implements Day {
    @Override
    public String part1(List<String> input) {
        int result = 0;
        int[] ints = input.stream().mapToInt(i -> Integer.parseInt(i)).toArray();

        for(int i = 0; i < ints.length - 1; i += 1) {
            if(ints[i + 1] > ints[i]) {
                result += 1;
            }
        }

        return Integer.toString(result);
    }

    @Override
    public String part2(List<String> input) {
        int result = 0;
        int[] ints = input.stream().mapToInt(i -> Integer.parseInt(i)).toArray();

        int prev = 0;
        int current = 0;

        for(int i = 0; i < ints.length - 2; i += 1) {
            prev = current;
            current = ints[i] + ints[i + 1] + ints[i + 2];

            if(i == 0) {
                continue;
                // handle first comparison
            }

            if(current > prev) result++;
        }

        return Integer.toString(result);
    }

}
