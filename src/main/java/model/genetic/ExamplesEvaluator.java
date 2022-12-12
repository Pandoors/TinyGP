package model.genetic;

import java.util.List;

public class ExamplesEvaluator {

    private static final String error = "ERROR";

    public static boolean checkIfOuputLenEqExp(List<String> output, List<String> exoutput) {
        return output.size() == exoutput.size();
    }

    public static boolean checkIfError(String s) {
        return error.equals(s);
    }

    public static boolean checkIfAtLeastOneOne(List<String> output) {

        if (output.size() == 1 && output.get(0) != null) {
            String s = output.get(0);
            if (checkIfError(s)) {
                return false;
            }

            return s.contains("1");


        } else {
            return false;
        }
    }
}
