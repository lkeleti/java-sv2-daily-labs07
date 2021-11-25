package day04.infErettsegi2021Okt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SudokuController {
    private SudokuTable sudokuTable = new SudokuTable();
    private List<String> remainingSteps;

    public List<String> getRemainingSteps() {
        return remainingSteps;
    }

    public void readFileToSudokuTable(Path path) {
        List<String> lines;
        lines = readFile(path);
        fillTableFromLines(lines);
    }

    private List<String> readFile(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return lines;
    }

    private void fillTableFromLines(List<String> lines) {
        for (int i = 0; i < 9; i++) {
            String[] datas = lines.get(i).split(" ");
            if (i < 9) {
                for (int j = 0; j < 9; j++) {
                    sudokuTable.fillCell(i, j, Integer.parseInt(datas[j]));
                }
            }
        }
        remainingSteps = lines.subList(9, lines.size());
    }

    public int getValue(int row, int column) {
        return sudokuTable.getValue(row, column);
    }

    public int countSegmentNumber(int row, int column) {
        return ((row / 3) + ((column / 3) * 3) + 1);
    }

    public int countEmptyCells() {
        int emptyCells = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuTable.getTable()[i][j] == 0) {
                    emptyCells++;
                }
            }
        }
        return emptyCells;
    }

    public Errors checkEmpty(int row, int column) {
        return sudokuTable.checkEmpty(row, column);
    }
    public Errors checkRow(int row, int column, int value) {
        return sudokuTable.checkRow(row, column, value);
    }

    public Errors checkCol(int row, int column, int value) {
        return sudokuTable.checkCol(row, column, value);
    }

    public Errors checkSegments(int row, int column, int value) {
        return sudokuTable.checkSegments(row, column, value);
    }
}
