package com.github.welingtonveiga.xadrez.model;

public class Position {

    private final int row;
    private final int col;

    public static Position of(int x, int y) {
        if (isInBoardPosition(x) && isInBoardPosition(y))
            return new Position(x, y);
        else
            throw new IllegalArgumentException("Out of range position.");
    }

    private Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    private static boolean isInBoardPosition(int x) {
        return x >= 0 && x < 8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (row != position.row) return false;
        return col == position.col;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
