package day04.infErettsegi2021Okt;

import java.nio.file.Paths;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        SudokuController sudokuController = new SudokuController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. feladat");
        System.out.print("Adja meg a bemeneti fájl nevét! ");
        String fileName = scanner.nextLine();
        System.out.print("Adja meg egy sor számát! ");
        int row = scanner.nextInt()-1;
        System.out.print("Adja meg egy oszlop számát! ");
        int column = scanner.nextInt()-1;

        System.out.println("2. feladat");
        sudokuController.readFileToSudokuTable(Paths.get("src/main/resources/sudoku/" + fileName));

        System.out.println("3. feladat");
        int value = sudokuController.getValue(row, column);
        System.out.println("Az adott helyen szereplő szám: " + (value == 0 ? "Az adott helyet még nem töltötték ki.":value));
        System.out.printf("A hely a(z) %d résztáblázathoz tartozik. %n", sudokuController.countSegmentNumber(row, column));
        System.out.println("4. feladat");
        System.out.printf("Az üres helyek aránya: %.1f%%", sudokuController.countEmptyCells()/81d*100);

        System.out.println("5. feladat");
        for (String line: sudokuController.getRemainingSteps()) {
            String[] datas = line.split(" ");
            int rowToFill = Integer.parseInt(datas[1])-1;
            int colToFill = Integer.parseInt(datas[2])-1;
            int valueToFill = Integer.parseInt(datas[0]);
            System.out.printf("A kiválasztott sor: %d oszlop: %d a szám: %d%n", rowToFill+1, colToFill+1, valueToFill);
            Errors errorValue = sudokuController.checkEmpty(rowToFill, colToFill);
            if (errorValue != Errors.OK) {
                System.out.println(errorValue.getValueHun());
            }
            else {
                errorValue = sudokuController.checkRow(rowToFill, colToFill, valueToFill);
                if (errorValue != Errors.OK) {
                    System.out.println(errorValue.getValueHun());
                } else {
                    errorValue = sudokuController.checkCol(rowToFill, colToFill, valueToFill);
                    if (errorValue != Errors.OK) {
                        System.out.println(errorValue.getValueHun());
                    } else {
                        errorValue = sudokuController.checkSegments(rowToFill, colToFill, valueToFill);
                        System.out.println(errorValue.getValueHun());
                    }
                }
            }
        }
    }
}
