package Modes;

import backend.SudokuBoard;
import backend.ValidationResult;
import factory.Validator;
import threads.BoxChecker;
import threads.ColumnChecker;
import threads.RowChecker;

public class TwentySevenThreadsValidator implements Validator {
    SudokuBoard SB;
    int i;
    ValidationResult VR=new ValidationResult();
        public TwentySevenThreadsValidator(SudokuBoard board)
        {
            this.SB=board;
        }

    @Override
    public ValidationResult validate() {
        BoxChecker [] boxCheckers=new BoxChecker[9];
        ColumnChecker [] columnCheckers=new ColumnChecker[9];
        RowChecker [] rowCheckers=new RowChecker[9];
        Thread [] boxThreads=new Thread[9];
        Thread [] rowThreads=new Thread[9];
        Thread [] columnThreads=new Thread[9];
//        System.out.println("oh Shit here we go again");
        for(i=0;i<9;i++)
        {
            boxCheckers[i]=new BoxChecker(SB,i,VR);
            columnCheckers[i]=new ColumnChecker(SB,i,VR);
            rowCheckers[i]=new RowChecker(SB,i,VR);
            boxThreads[i]=new Thread(boxCheckers[i]);
            rowThreads[i]=new Thread(rowCheckers[i]);
            columnThreads[i]=new Thread(columnCheckers[i]);
        }
        for(i=0;i<9;i++)
        {
            boxThreads[i].start();
            rowThreads[i].start();
            columnThreads[i].start();
        }

        for(i=0;i<9;i++)
        {
            try {
                boxThreads[i].join();
                rowThreads[i].join();
                columnThreads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
//        VR.printReport();
//        System.out.println("Mission Passed");
        return VR;
    }
}
