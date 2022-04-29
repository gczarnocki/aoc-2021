package aoc.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BingoBoard {
    private final int INPUT_SIZE = 5;
    private final Pattern numberPattern = Pattern.compile("[0-9]+");

    private List<BingoField> fields;

    public BingoBoard(List<String> input) {
        fields = new ArrayList<BingoField>(INPUT_SIZE * INPUT_SIZE); // nxn table

        int j = 0;

        for(String s : input) {
            Matcher matcher = numberPattern.matcher(s);

            while(matcher.find()) {
                fields.add(new BingoField(j, Integer.parseInt(matcher.group())));
                j++;
            }

            assert j == fields.size();
        }
    }

    public boolean checkIfBoardWins() {
        for(int i = 0; i < INPUT_SIZE; i++) {
            if(checkIfColumnIsFullyMarked(i) || checkIfRowIsFullyMarked(i)) {
                return true;
            }
        }

        return false;
    }

    public int getSumOfAllUnmarkedFields() {
        return fields.stream().filter(field -> !field.isMarked()).mapToInt(x -> x.getValue()).sum();
    }

    public boolean checkIfRowIsFullyMarked(int rowId) {
        int startIndex = rowId * INPUT_SIZE;
        return fields.subList(startIndex, startIndex + INPUT_SIZE - 1).stream().allMatch(x -> x.isMarked());
    }

    public boolean checkIfColumnIsFullyMarked(int columnId) {
        return fields.stream().filter(x -> x.getLocation() % INPUT_SIZE == columnId).allMatch(x -> x.isMarked());
    }

    public void markField(int value) {
        Optional<BingoField> field = fields.stream().filter(x -> x.getValue() == value).findAny();
        if(field.isPresent()) field.get().setMarked(true);
    }
}
