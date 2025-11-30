package threads;

import backend.*;

public class RowChecker extends Checker{      // each object from this class will represent a thread that deals with a row in a Sodoku board

    public RowChecker(SudokuBoard board, int index, ValidationResult result) {
        /*this.board = board;
        this.index = index;
        this.result = result;*/
        super(board,index,result);
    }

    @Override
    public int[] getPartArray() {
        return board.getRow(index);
    }

    @Override
    public String getPartLabel() {
        return "ROW ";
    }


}
