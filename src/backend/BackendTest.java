package backend;

public class BackendTest {
    public static void main(String[] args) {

        try {

            SudokuBoard board = new SudokuBoard("Sudoku.csv");

            SequentialValidator validator = new SequentialValidator(board);

            ValidationResult result = validator.validate();

            result.printReport();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
