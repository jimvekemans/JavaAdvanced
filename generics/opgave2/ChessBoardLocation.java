package opgave2;

public class ChessBoardLocation {
    private int row;
    private char column;

    public ChessBoardLocation(char column, int row) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.valueOf(column) + row;
    }
}
