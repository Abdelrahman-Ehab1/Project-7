package threads;

import backend.SequentialValidator;
import backend.SudokuBoard;
import backend.ValidationResult;

import java.util.List;
import java.util.Map;

public class ColumnChecker implements Runnable{// each object from this class will represent a thread that deals with a row in a Sodoku board
    private SudokuBoard board ;
    private int index;
    private ValidationResult result;

    public ColumnChecker(SudokuBoard board, int index, ValidationResult result) {
        this.board = board;
        this.index = index;
        this.result = result;
    }

    @Override
    public void run() {
        int[] column = board.getColumn(index);
        SequentialValidator validator = new SequentialValidator(board);
        Map<Integer, List<Integer>> duplicates = validator.findDuplicatePositions(column);

        for (int num : duplicates.keySet()) {
            result.addError("COL " + (index + 1) + ", #" + num + ", " + validator.formatPositions(duplicates.get(num)));
        }

    }
}
