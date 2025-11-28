package backend;

import java.io.*;


public class SudokuBoard {
    private final int[][] board = new int[9][9];

    public SudokuBoard(String csvFilePath) throws IOException {
        readCSV(csvFilePath);
    }

    // reads mn el csv file w by7t el values fy el 2d array
    private void readCSV(String filePath) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String l;
            int rowNum = 0;

            while ((l = buffer.readLine()) != null && rowNum< 9) {
                String[] parts = l.split(",");

                for (int colNum = 0; colNum < 9; colNum++) {
                    board[rowNum][colNum] = Integer.parseInt(parts[colNum]);
                }
                rowNum++;
            }
        }
    }

    // byrg3 cell
    public int getCell(int row, int col) {
        return board[row][col];
    }

    // byrg3 row kaml
    public int[] getRow(int row) {

        return board[row].clone();
    }

    // byrg3 coloumn kaml
    public int[] getColumn(int col) {
        int[] column = new int[9];
        for (int row = 0; row < 9; row++) {
            column[row] = board[row][col];
        }
        return column;
    }

    // byrg3 box
    public int[] getbox(int boxIndex) {

        int[] boxValues = new int[9];
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;

        int wrIndex = 0;

        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                boxValues[wrIndex++] = board[r][c];
            }
        }

        return boxValues;
    }


}
