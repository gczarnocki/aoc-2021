package aoc.day04;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day04 implements Day {
    List<BingoBoard> boards;

    @Override
    public String part1(List<String> input) {
        int[] numbersToDraw = Arrays.stream(input.get(0).split(",")).mapToInt(x -> Integer.parseInt(x)).toArray();

        input = input.subList(2, input.size());

        boards = loadBingoBoards(input);

        for(int number : numbersToDraw) {
            BingoBoard winningBoard = markNumberInBoards(number);

            if(winningBoard != null) {
                return Integer.toString(number * winningBoard.getSumOfAllUnmarkedFields());
            }
        }

        return "-1";
    }

    private int getWinningNumber() {
        for(int i = 0; i < boards.size(); i++) {
            if(boards.get(i).checkIfBoardWins()) {
                return i;
            }
        }

        return -1;
    }

    private BingoBoard markNumberInBoards(int number) {
        for(BingoBoard board : boards) {
            board.markField(number);

            if(board.checkIfBoardWins()) {
                return board;
            }
        }

        return null;
    }

    private List<BingoBoard> markNumberInBoardsMultiple(List<BingoBoard> boards, int number) {
        List<BingoBoard> winningBoards = new ArrayList<>();

        for(BingoBoard board : boards) {
            board.markField(number);

            if(board.checkIfBoardWins()) {
                winningBoards.add(board);
            }
        }

        return winningBoards;
    }

    private List<BingoBoard> loadBingoBoards(List<String> input) {
        List<BingoBoard> boards = new ArrayList<BingoBoard>();
        List<String> singleInput = new ArrayList<String>();

        for(int i = 0; i < input.size(); i++) {
            if(input.get(i).trim().isEmpty()) {
                // handle new board
                boards.add(new BingoBoard(singleInput));
                singleInput.clear();
            } else {
                singleInput.add(input.get(i));
            }
        }

        if(singleInput.size() > 0) {
            boards.add(new BingoBoard(singleInput));
        }

        return boards;
    }

    @Override
    public String part2(List<String> input) {
        List<BingoBoard> winningBoards = new ArrayList<BingoBoard>();
        BingoBoard lastWinningBoard = null;
        int lastNumber = 0;

        int[] numbersToDraw = Arrays.stream(input.get(0).split(",")).mapToInt(x -> Integer.parseInt(x)).toArray();
        input = input.subList(2, input.size());

        boards = loadBingoBoards(input);

        for (int number : numbersToDraw) {
            winningBoards = markNumberInBoardsMultiple(boards, number);
            lastNumber = number;

            boards.removeAll(winningBoards);

            if(boards.stream().anyMatch(x -> x.checkIfBoardWins())) {
                System.out.println("HERE");
            }

            if(winningBoards.size() > 0) {
                lastWinningBoard = winningBoards.get(winningBoards.size() - 1);
            }

            winningBoards.clear();

            if(boards.size() == 0) break;
        }

        if(lastWinningBoard != null) {
            return Integer.toString(lastNumber * lastWinningBoard.getSumOfAllUnmarkedFields());
        } else {
            return "-1";
        }
    }
}
