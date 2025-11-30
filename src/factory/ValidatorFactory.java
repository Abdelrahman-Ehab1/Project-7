package factory;

import backend.SequentialValidator;
import Modes.ThreeThreadsValdator;
import Modes.TwentySevenThreadsValdator;
import backend.SudokuBoard;

public class ValidatorFactory {
    public static Validator createValidatorobj(int mode , SudokuBoard board){
        if(mode == 0){
            return new SequentialValidator(board);
        }
        else if(mode == 3){
            return new ThreeThreadsValidator(board);
        }
        else if(mode == 27){
            return new TwentySevenThreadsValidator(board);
        }
        else{
             throw new IllegalArgumentException("Invalid mode. Must be 0,3 or 27");
        }
    }

}
