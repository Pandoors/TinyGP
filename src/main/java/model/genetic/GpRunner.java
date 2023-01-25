package model.genetic;

import model.Node;
import model.Program;

import java.util.List;

public class GpRunner {

    public static void main(String[] args) {

        Solver solver = new Solver("/Users/bartosz/IdeaProjects/TinyGP/src/main/java/inputFiles/test_final_1.txt");
        solver.solve();


    }

}
