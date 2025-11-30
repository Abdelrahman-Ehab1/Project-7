package Modes;

import backend.SudokuBoard;
import backend.ValidationResult;
import factory.Validator;
import threads.BoxChecker;
import threads.ColumnChecker;
import threads.RowChecker;
import java.io.IOException;

public class ThreeThreadsValidator implements Validator {
SudokuBoard SB;
    int i;
   ValidationResult VR=new ValidationResult();

    public ThreeThreadsValidator(SudokuBoard board){
       this.SB=board;
    }

    @Override
    public ValidationResult validate() {
//        System.out.println("oh Shit here we go again");
        for(i=0;i<9;i++)
        {
            BoxChecker boxChecker=new BoxChecker(SB,i,VR);
            ColumnChecker columnChecker=new ColumnChecker(SB,i,VR);
            RowChecker rowChecker=new RowChecker(SB,i,VR);
            Thread BoxThread=new Thread(boxChecker);
            Thread RowThread=new Thread(rowChecker);
            Thread ColumnThread=new Thread(columnChecker);
            BoxThread.start();
            RowThread.start();
            ColumnThread.start();
            try {
                BoxThread.join();
                RowThread.join();
                ColumnThread.join();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        VR.printReport();
//        System.out.println("Mission Passed");
        return VR;
    }
}
