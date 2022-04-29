package aoc.day03;

import aoc.Day;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day03 implements Day {
    @Override
    public String part1(List<String> input) {
        Integer inputCount = input.size();
        Integer inputSize = input.get(0).length();

        int[] zerosCount = new int[inputSize];

        for(int i = 0; i < inputSize; i++) {
            zerosCount[i] = countZerosOnPosition(input, i);
        }

        // TODO: This is really ugly.
        String result = Arrays.stream(zerosCount).
                mapToObj(x -> (x > inputCount / 2) ? "0" : "1").
                collect(Collectors.joining());

        int gamma = Integer.parseInt(result, 2);

        String epsilonResult = Arrays.stream(zerosCount).
                mapToObj(x -> (x < inputCount / 2) ? "0" : "1").
                collect(Collectors.joining());

        int epsilon = Integer.parseInt(epsilonResult, 2);

        return String.valueOf(gamma * epsilon);
    }

    public Integer calculateRating(List<String> input, RatingType type) {
        int inputSize = input.get(0).length();

        for(int i = 0; i < inputSize; i++) {
            char bit = '-';

            switch(type) {
                case OXYGEN:
                    bit = getMostCommonBitAtLocation(input, i);
                    break;
                case CO2:
                    bit = getLeastCommonBitAtLocation(input, i);
                    break;
            }

            final int finalI = i;
            final char finalBit = bit;

            input = input.stream().
                    filter(x -> x.charAt(finalI) == finalBit).
                    collect(Collectors.toList());

            if(input.size() == 1) {
                return Integer.parseInt(input.get(0), 2);
            }
        }

        return 0;
    }

    private Integer countZerosOnPosition(List<String> input, int position) {
        int zerosCount = 0;

        for (String s : input) {
            if (s.charAt(position) == '0') {
                zerosCount++;
            }
        }

        return zerosCount;
    }

    // TODO: Refactor to one method
    private char getMostCommonBitAtLocation(List<String> input, int position) {
        if(position >= input.get(0).length()) {
            throw new IllegalArgumentException("<position> is bigger than <input>'s length.");
        }

        int inputLength = input.size();
        int zerosCount = countZerosOnPosition(input, position);

        if(zerosCount * 2 == inputLength) return '1';

        return zerosCount > (inputLength / 2) ? '0' : '1';
    }

    private char getLeastCommonBitAtLocation(List<String> input, int position) {
        if(position >= input.get(0).length()) {
            throw new IllegalArgumentException("<position> is bigger than <input>'s length.");
        }

        int inputLength = input.size();
        int zerosCount = countZerosOnPosition(input, position);

        if(zerosCount * 2 == inputLength) return '0';

        return zerosCount > (inputLength / 2) ? '1' : '0';
    }

    private enum RatingType {
        OXYGEN,
        CO2
    }

    @Override
    public String part2(List<String> input) {
        Integer oxy = calculateRating(input, RatingType.OXYGEN);
        Integer co2 = calculateRating(input, RatingType.CO2);

        return String.valueOf(oxy * co2);
    }

}
