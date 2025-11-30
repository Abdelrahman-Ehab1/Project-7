import backend.SudokuBoard;
import backend.ValidationResult;
import factory.Validator;
import factory.ValidatorFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        long start = System.nanoTime();
        SudokuBoard board = new SudokuBoard("Sudoku.csv");
        int mode = 3;

        Validator validator = ValidatorFactory.createValidatorobj(mode, board);

        ValidationResult result = validator.validate();

        result.printReport();



        long end = System.nanoTime();

        System.out.println("Time taken: " + (end - start)/1_000_000 + " ms");
    }
}