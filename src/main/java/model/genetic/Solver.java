package model.genetic;

import lombok.NoArgsConstructor;
import model.Program;
import org.apache.commons.math3.util.IntegerSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        evaluate();

    }

    public void evaluate(){
        // tournament -> crossover2 best -> negative tournament -> mutation
        switch (new Random().nextInt(2)){
            case 0:
                mutation();
                break;
            case 1:
                Program program = Operations.cross(tournament(2).get(0), tournament(2).get(1));
                for(int i = 0; i< negative_tournament(1).size();  i++){
                    programs.set(i, program);
            }
        }
    }

    public List<Program> tournament(int a){
        List<Program> winners= new ArrayList<>();
        for(int i = 0; i< a; i++){
            winners.add(programs.get(new Random().nextInt(programs.size())));

        }
        return winners;
    }
    public List<Integer> negative_tournament(int a ){
        List<Integer> winners= new ArrayList<>();
        for(int i = 0; i< a; i++){
            winners.add(i);
        }
        return winners;
    }
    public void mutation(){
        int a = new Random().nextInt(programs.size());
        this.programs.set(a, (Program) Operations.mutation(programs.get(a)));

    }


}
