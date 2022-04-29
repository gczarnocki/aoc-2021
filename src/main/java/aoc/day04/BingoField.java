package aoc.day04;

public class BingoField {
    private int location;
    private boolean marked;
    private int value;

    public BingoField(int location, int value) {
        this.location = location;
        this.value = value;
        setMarked(false);
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public boolean isMarked() {
        return marked;
    }

    public int getValue() {
        return value;
    }

    public int getLocation() {
        return location;
    }
}
