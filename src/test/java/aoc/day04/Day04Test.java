package aoc.day04;

import aoc.day04.Day04;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day04Test {
    private List<String> input = Arrays.asList(
            "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1",
            "",
            "22 13 17 11  0",
            "8  2 23  4 24",
            "21  9 14 16  7",
            "6 10  3 18  5",
            "1 12 20 15 19",
            "",
            "3 15  0  2 22",
            "9 18 13 17  5",
            "19  8  7 25 23",
            "20 11 10 24  4",
            "14 21 16 12  6",
            "",
            "14 21 17 24  4",
            "10 16 15  9 19",
            "18  8 23 26 20",
            "22 11 13  6  5",
            "2  0 12  3  7"
    );

    private List<String> input1 = Arrays.asList(
        "1  2  3  4  5",
        "6  7  8  9  10",
        "11 12 13 14 15",
        "16 17 18 19 20",
        "21 22 23 24 25"
    );

    private List<String> input2 = Arrays.asList(
        "50  2  3  4  5",
        "6  50  8  9  10",
        "11 12 50 14 15",
        "16 17 18 50 20",
        "21 22 23 24 50"
    );

    @Test
    public void testCheckIfRowIsFullyMarked() {
        BingoBoard board1 = new BingoBoard(input1);
        Arrays.asList(1, 2, 3, 4, 5).stream().forEach(n -> board1.markField(n));

        assertEquals(true, board1.checkIfRowIsFullyMarked(0));
    }

    @Test
    public void testCheckIfColumnIsFullyMarked() {
        BingoBoard board1 = new BingoBoard(input1);
        Arrays.asList(1, 6, 11, 16, 21).stream().forEach(n -> board1.markField(n));

        assertEquals(true, board1.checkIfColumnIsFullyMarked(0));
    }

    @Test
    public void testCheckIfBoardWins() {
        BingoBoard board1 = new BingoBoard(input1);
        Arrays.asList(1, 6, 11, 16, 21).stream().forEach(n -> board1.markField(n));

        assertEquals(true, board1.checkIfBoardWins());
    }

    @Test
    public void testGetSumOfAllUnmarkedFields() {
        BingoBoard board1 = new BingoBoard(input1);
        Arrays.asList(2, 7, 12, 17, 22).stream().forEach(n -> board1.markField(n));

        assertEquals(265, board1.getSumOfAllUnmarkedFields());
    }

    @Test
    public void testPart2() {
        // When
        String result = new Day04().part2(input);

        // Then
        assertEquals("1924", result);
    }
}
