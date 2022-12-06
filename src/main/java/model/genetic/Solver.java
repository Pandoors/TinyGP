package model.genetic;

import lombok.NoArgsConstructor;
import model.Program;
import org.apache.commons.math3.util.IntegerSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Solver {
    private int epoch=0;
    private final Integer eps = 1;
    private List<Program> programs = new ArrayList<>();

    public Solver() {
        int reachedFitness = 0;

        for (int i : new IntegerSequence.Range(0, 100, 1)) {
            programs.add(new Program(false));
        }


    }

    public void solve() {
        evaluate();
    }

    public void evaluate() {
        // tournament -> crossover2 best -> negative tournament -> mutation
        switch (new Random().nextInt(2)) {
            case 0:
                mutation();
                break;
            case 1:
                List<Program> tournamentResult = tournament(2);
                Program program = Operations.cross(tournamentResult.get(0), tournamentResult.get(1));
                for (int i = 0; i < negative_tournament(1).size(); i++) {
                    programs.set(i, program);

                }

        }
    }

    public List<Program> tournament(int a) {
        List<Program> winners = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            winners.add(programs.get(new Random().nextInt(programs.size())));

        }
        return winners;
    }

    public List<Integer> negative_tournament(int a) {
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            winners.add(i);
        }
        return winners;
    }

    public void mutation() {
        int a = run();
        this.programs.set(a, (Program) Operations.mutation(programs.get(a)));

    }

    private int run() {
        return new Random().nextInt(programs.size());
    }

    private void calculateEvaluation() {

        for (Program program : this.programs) {
            String program_txt = program.getTreeProgTxt();
        }

    }

//    private void saveAndCompile

    private void printEpoch(){
        System.out.println("Epoch: " + epoch++ + "score: ");
    }
}
