package backend;

import java.util.*;

// this class used for mode 0 to check all rows,columns,boxes for duplicate digits
public class SequentialValidator {

    private final SudokuBoard board;

    public SequentialValidator(SudokuBoard board) {
        this.board = board;
    }

    // btrg3 ValidationResult feha kol el errors
    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();

        checkAllRows(result);
        checkAllColumns(result);
        checkAllBoxes(result);

        return result;
    }


    private void checkAllRows(ValidationResult result) {
        for (int row = 0; row < 9; row++) {
            int[] rowData = board.getRow(row);
            Map<Integer, List<Integer>> duplicates = findDuplicatePositions(rowData);

            for (int num : duplicates.keySet()) {
                result.addError("ROW " + (row + 1) + ", #" + num + ", " + formatPositions(duplicates.get(num)));
            }
        }
    }


    private void checkAllColumns(ValidationResult result) {
        for (int col = 0; col < 9; col++) {
            int[] colData = board.getColumn(col);
            Map<Integer, List<Integer>> duplicates = findDuplicatePositions(colData);

            for (int num : duplicates.keySet()) {
                result.addError("COL " + (col + 1) + ", #" + num + ", " + formatPositions(duplicates.get(num)));
            }
        }
    }


    private void checkAllBoxes(ValidationResult result) {
        for (int box = 0; box < 9; box++) {
            int[] boxData = board.getbox(box);
            Map<Integer, List<Integer>> duplicates = findDuplicatePositions(boxData);

            for (int num : duplicates.keySet()) {
                result.addError("BOX " + (box + 1) + ", #" + num + ", " + formatPositions(duplicates.get(num)));
            }
        }
    }



    /*
      Finds all duplicated numbers in an array and their positions (1 based).
      Positions are either column numbers for rows or row numbers for columns
     or box positions 1–9 for boxes.
     */
    private Map<Integer, List<Integer>> findDuplicatePositions(int[] arr) {
        Map<Integer, List<Integer>> positionsMap = new HashMap<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (seen.containsKey(num)) {
                // awel mara ala2y duplicate a7ot el previous index
                if (!positionsMap.containsKey(num)) {
                    positionsMap.put(num, new ArrayList<>());
                    positionsMap.get(num).add(seen.get(num) + 1); // 1 based
                }
                // add current index
                positionsMap.get(num).add(i + 1); // 1 based
            }
            else {
                seen.put(num, i);
            }
        }
        return positionsMap;
    }

    //bgeb el positions of duplicate value
    private String formatPositions(List<Integer> positions) {
        String s="[";
        for (int i = 0; i < positions.size(); i++) {
            if (i > 0)
                s+=" ";
            s+=positions.get(i);
        }
        s+="]";
        return s;
    }
}
