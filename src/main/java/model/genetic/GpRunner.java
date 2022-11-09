package model.genetic;

import model.Node;
import model.Program;

import java.util.List;

public class GpRunner {

    public static void main(String[] args) {

        Solver solver = null;
        try {
            solver = new Solver(100);
            solver.solve();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
