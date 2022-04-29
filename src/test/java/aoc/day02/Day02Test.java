package aoc.day02;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day02Test {

    @Test
    public void testPart1(){
//        // Given
//        List<String> input = Collections.singletonList("test");
//
//        // When
//        String result = new Day02().part1(input);
//
//        // Then
//        assertEquals(input.get(0), result);
    }

    @Test
    public void testPart2(){
        // Given
        List<String> input = Arrays.asList(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"
        );

        // When
        String result = new Day02().part2(input);

        // Then
        assertEquals("900", result);
    }
}
