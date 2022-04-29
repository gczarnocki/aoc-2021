package aoc.day03;

import aoc.day02.Day02;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day03Test {
    private List<String> input = Arrays.asList(
            "00100", "11110",
            "10110", "10111",
            "10101", "01111",
            "00111", "11100",
            "10000", "11001",
            "00010", "01010"
    );

    @Test
    public void testPart1() {
        // When
        String result = new Day03().part1(input);

        // Then
        assertEquals("198", result);
    }

    @Test
    public void testPart2() {
        // When
        String result = new Day03().part2(input);

        // Then
        assertEquals("230", result);
    }
}
