import backend.SudokuBoard;
import backend.ValidationResult;
import factory.Validator;
import factory.ValidatorFactory;

public class Main {
    public static void main(String[] args) throws Exception {

        //args[0];  --> lel path mn gitbash
        //args[1];  --> lel mode mn gitbash
        long start = System.nanoTime();

        if(args.length < 2){  // lw 3ml insertion l arg wahed f gitbash
            System.out.println("Must be put in this format: <<args[0] --> FilePath>> <<args[1] --> mode>>");
        }

        String path = args[0];
        int mode = Integer.parseInt(args[1]);

        SudokuBoard board = new SudokuBoard(path);
        Validator validator = ValidatorFactory.createValidatorobj(mode, board);
        ValidationResult result = validator.validate();
        result.printReport();

        long end = System.nanoTime();

        System.out.println("Time taken: " + (end - start)/1_000_000 + " ms");
        //
    }
}