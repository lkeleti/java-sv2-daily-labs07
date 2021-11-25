package day04.infErettsegi2021Okt;

public class SudokuTable {
    private int[][] table = new int[9][9];

    public int[][] getTable() {
        return table;
    }

    public boolean fillCell(int row, int column, int value) {
        if (checkCell(row, column, value)){
            table[row][column] = value;
            return true;
        }
        return false;
    }

    private boolean checkCell(int row, int column, int value) {
        return checkRow(row, column, value) == Errors.OK &&
                checkCol(row, column, value) == Errors.OK &&
                checkSegments(row, column, value) == Errors.OK;
    }

    public Errors checkEmpty(int row, int column) {
        return table[row][column] == 0? Errors.OK: Errors.RESERVED;
    }

    public Errors checkRow(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (table[row][i] == value && i != column) {
                return Errors.INTHEROW;
            }
        }
        return Errors.OK;
    }

    public Errors checkCol(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (table[i][column] == value && i != row) {
                return Errors.INTHECOL;
            }
        }
        return Errors.OK;
    }

    public Errors checkSegments(int row, int column, int value) {
        int segmentRow = row / 3;
        int segmentCol = column / 3;
        for (int i = segmentRow * 3; i < (segmentRow * 3) +3; i++) {
            for (int j = segmentCol * 3; j < (segmentCol * 3) +3; j++) {
                if (table[i][j] == value && (i != row && j != column)) {
                    return Errors.INTHESEGMENT;
                }
            }
        }
        return Errors.OK;
    }

    public int getValue(int row, int column) {
        return table[row][column];
    }
}
