package threads;

import backend.*;

public class ColumnChecker extends Checker{      // each object from this class will represent a thread that deals with a column in a Sodoku board

    public ColumnChecker(SudokuBoard board, int index, ValidationResult result) {
        /*this.board = board;
        this.index = index;
        this.result = result;*/
        super(board,index,result);
    }

    @Override
    public int[] getPartArray() {
        return board.getColumn(index);
    }

    @Override
    public String getPartLabel() {
        return "COL ";
    }


}
