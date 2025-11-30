package threads;

import backend.*;

public class BoxChecker extends Checker{      // each object from this class will represent a thread that deals with a box in a Sodoku board
    public BoxChecker(SudokuBoard board, int index, ValidationResult result) {
        /*this.board = board;
        this.index = index;
        this.result = result;*/
        super(board,index,result);
    }

    @Override
    public int[] getPartArray() {
        return board.getbox(index);
    }

    @Override
    public String getPartLabel() {
        return "BOX ";
    }


}
