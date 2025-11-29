package backend;

import java.util.*;

public class SequentialValidator {

    private final SudokuBoard board;

    public SequentialValidator(SudokuBoard board) {
        this.board = board;
    }

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        validateSet("ROW", board::getRow, result);  //(board::getRow) is a method reference
        validateSet("COL", board::getColumn, result);
        validateSet("BOX", board::getbox, result);

        return result;
    }


    // Generic validator
    private void validateSet(String field, DataFetcher f, ValidationResult result) {
        for (int index = 0; index < 9; index++) {
            int[] data = f.get(index);
            Map<Integer, List<Integer>> duplicates = DuplicateUtils.findDuplicatePositions(data);

            for (int num : duplicates.keySet()) {
                result.addError(field + " " + (index + 1) + ", #" + num + ", " + FormatPositionsUtils.formatPositions(duplicates.get(num))
                );
            }
        }
    }
}