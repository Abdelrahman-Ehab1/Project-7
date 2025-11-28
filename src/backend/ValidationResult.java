package backend;

import java.util.*;


        //hena a7na bngm3 el validation errors mn rows, columns, boxes w n7thom fy arraylist
public class ValidationResult {

    private final List<String> errors = new ArrayList<>();


    public void addError(String message) {

        errors.add(message);
    }
    

    public boolean isValid() {

        return errors.isEmpty();
    }


    public List<String> getErrors() {
        return errors;
    }


    public void printReport() {
        if (isValid()) {
            System.out.println("Valid");
            return;
        }
        System.out.println("Invalid");

        for (String error : errors) {
            System.out.println(error); //by2olak fen el errors bzbt
        }
    }
}

