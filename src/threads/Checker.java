package threads;

import backend.DuplicateUtils;
import backend.FormatPositionsUtils;
import backend.SudokuBoard;
import backend.ValidationResult;

import java.util.List;
import java.util.Map;

public abstract class Checker implements Runnable{

    protected SudokuBoard board ;
    protected int index;
    protected ValidationResult result;
    // I had to make these attributes protected because, children must have access on them

    public Checker(SudokuBoard board, int index, ValidationResult result) {
        this.board = board;
        this.index = index;
        this.result = result;
    }

    public abstract int [] getPartArray();
    public abstract String getPartLabel();

    @Override
    public void run() {

        int[] arrayOfPart = getPartArray();
        Map<Integer, List<Integer>> duplicates = DuplicateUtils.findDuplicatePositions(arrayOfPart);

        for (int num : duplicates.keySet()) {
            result.addError( getPartLabel() + (index + 1) + ", #" + num + ", " + FormatPositionsUtils.formatPositions(duplicates.get(num)));
        }
    }
}
