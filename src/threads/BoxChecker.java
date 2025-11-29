package threads;

import backend.*;


import java.util.List;
import java.util.Map;

public class BoxChecker implements Runnable{// each object from this class will represent a thread that deals with a row in a Sodoku board
    private SudokuBoard board ;
    private int index;
    private ValidationResult result;

    public BoxChecker(SudokuBoard board, int index, ValidationResult result) {
        this.board = board;
        this.index = index;
        this.result = result;
    }

    @Override
    public void run() {
        int[] box = board.getbox(index);
       // SequentialValidator validator = new SequentialValidator(board);
        Map<Integer, List<Integer>> duplicates = DuplicateUtils.findDuplicatePositions(box);

        for (int num : duplicates.keySet()) {
            result.addError("BOX " + (index + 1) + ", #" + num + ", " + FormatPositionsUtils.formatPositions(duplicates.get(num)));
        }

    }
}
