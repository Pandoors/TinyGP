package model.genetic;

import lombok.NoArgsConstructor;
import model.Program;
import org.apache.commons.math3.util.IntegerSequence;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Solver {

    private Integer fitness;
    private final Integer eps = 1;
    private List<Program> programs = new ArrayList<>();
    public Solver(Integer fitness) throws Exception {
        int reachedFitness = 0;
        if (fitness == null) {
            throw new Exception("fitness cannot be null");
        }

        for (int i : new IntegerSequence.Range(0, 100, 1)){
            programs.add(new Program(false));
        }


//            while (Math.abs(fitness - reachedFitness) < this.eps) {
//
//                for ()
//
//
//            }

    }

    public void solve() {


    }


}
