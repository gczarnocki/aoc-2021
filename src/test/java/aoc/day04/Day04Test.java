package aoc.day04;

import aoc.day04.Day04;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day04Test {
    private List<String> input = Arrays.asList(
        "2,7,12,17,22",
        "",
        "1  2  3  4  5",
        "6  7  8  9  10",
        "11 12 13 14 15",
        "16 17 18 19 20",
        "21 22 23 24 25",
        "",
        "50  2  3  4  5",
        "6  50  8  9  10",
        "11 12 50 14 15",
        "16 17 18 50 20",
        "21 22 23 24 50"
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
