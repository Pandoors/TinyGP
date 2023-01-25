package model.genetic;

import lombok.NoArgsConstructor;
import model.Program;
import model.tokenNode.TokenNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.math3.util.IntegerSequence;
import visitor.BobaroLexer;
import visitor.BobaroParser;
import visitor.own.BobaroVisitor;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solver {
    private int epoch=0;
    private final int epochs = 1000;
    private List<Program> programs = new ArrayList<>();
    private String outputFilename = "/Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/output.txt";
    private int sigmaProgramId;
    private int avgFitnessInEpoch;
    private String path;
    private double reachedFitness;
    public Solver(String path) {
        this.path = path;
        this.reachedFitness = 0;

        for (int i : new IntegerSequence.Range(0, 100, 1)) {
            programs.add(new Program(false));
        }


    }

    public void solve() {

//        saveAndCompile(programs.get(0), " 100 0 0 0 0 0 0 0 ");
        int size = programs.size();
        for (int i : new IntegerSequence.Range(1, epochs, 1)) {
            epoch = i;
//            if (fBestPop > -1e-5) { todo
//                System.out.print("PROBLEM SOLVED\n");
//                System.exit(0);
//            }
//            for (Program indiv : programs) {
//                evaluate(indiv);
//
//            }
            printEpochStarted();
            for (int j=0; j < size; j++){
                evaluate(programs.get(j));
            }
            printEpoch();
        }


    }

    public void evaluate(Program indiv) {
        // tournament -> crossover2 best -> negative tournament -> mutation
        switch (new Random().nextInt(2)) {
            case 0:
                Program new_mutated = mutation(indiv);
                new_mutated.setReachedFitness(fitness(new_mutated));
                this.reachedFitness = Math.max(new_mutated.getReachedFitness(), this.reachedFitness);
                this.programs.add(new_mutated);
                break;
            case 1:
                Program child = cross(indiv, tournament());
                child.setReachedFitness(fitness(child));
                this.reachedFitness = Math.max(child.getReachedFitness(), this.reachedFitness);
                this.programs.add(child);
                break;
        }
//        System.out.println("Best fitness: " + this.reachedFitness);
        negativeTournament();
    }

    private Program cross(Program parent1, Program parent2){
        return Operations.cross(parent1, parent2);
    }

    public Program tournament() {
        for(Program program: programs){
            if(program.getReachedFitness()==reachedFitness)
                return program;
        }
        return programs.get(0); //i tak się to nigdy nie wykona ale wrzuciłem to żeby się nie darło
    }

    public void negativeTournament () {
        double worstFitness = 0;

        Integer index = null;
        for (int i = 0; i < this.programs.size(); i++) {
            if (programs.get(i).getReachedFitness() < worstFitness) {
                index = i;
                break;
            }
        }

        if (index != null) {
            this.programs.remove(index.intValue());
            System.out.println("Usunieto w indeksie: " + index);
        }


    }

    public Program mutation(Program a) {
        return Operations.mutation(a);
    }

    public List<Integer> getProgramOutputs(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.outputFilename));
            String line;
            String outputs = "";
            while ((line = br.readLine()) != null) {
                outputs = outputs = outputs + " " + line;
            }
            return convert2List(outputs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // to nie powinno się nigdy wykona
    }

    public boolean isOutputEmpty(){
        File file = new File(this.outputFilename);
        if (file.length() == 0) {
            System.out.println("The file is empty");
            return true;
        } else {
            System.out.println("The file is not empty");
            return false;
        }
    }

    public double gradeOccurancesInFile(List<Integer> output) {
//        List<Integer> programOutputs = getProgramOutputs();
//        int count = 0;x
//        for(int i= 0; i<output.size(); i++){
//            for(int j=0; j<programOutputs.size();j++){
//                count ++;
//            }
//        }
//        return count/output.size();
//        List<Integer> programOutputs = getProgramOutputs();
//        if(output != null && !output.isEmpty() && programOutputs != null && !programOutputs.isEmpty()){
//        for (Integer element : output) {
//            if (programOutputs.contains(element)) {
//                count++;
//            }
//        }}
//        return count;
        return 0.0;
    }

    public double gradeDistanceBetweenOutputs(List<Integer> output){
        double grade = 0;
        List<Integer> programOutputs = getProgramOutputs();
        for(int i=0; i<output.size(); i++){
            if(output.get(i)==programOutputs.get(i))
                grade = 1_000_000;
            else
                grade = grade + (1/Math.abs(output.get(i)-programOutputs.get(i)));
        }
        return grade/output.size();
    }

    public boolean doesProgramRuns(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.outputFilename));
            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("ERROR")) return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean doesProgramHaveExpectedOutputLength(int outputLength){
        try {

            BufferedReader br = new BufferedReader(new FileReader(this.outputFilename));
            String line;
            int i= 0;
            while ((line = br.readLine()) != null) {
                i++;
            }
            return outputLength==i;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private double fittnes4Case(List<Integer> outputs, int checkOutputLength){
        //checking if the program returns error
        if(!doesProgramRuns()||isOutputEmpty()) return -1;
        if(checkOutputLength>0 ){
            //checking if the number of length of outputs matches number of expected outputs
            if(!doesProgramHaveExpectedOutputLength(outputs.size())) return 0.0;
            //read the file and return the sqrt of sum of squares
            return gradeDistanceBetweenOutputs(outputs);
        }else {
            return gradeOccurancesInFile(outputs);
        }
    }
    private List<Integer> convert2List(String s){
        String[] parts = s.split(" ");

        List<String> stringList = Arrays.asList(parts);
        List<Integer> numbers = stringList.stream().filter(n-> n!= null && !Objects.equals(n, ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    private double fitness(Program program){ // TODO: szczerze powiedziawszy to ja bym zrobił, że im mniejszy błąd tym lepszy fitness case?
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            String headerLine = br.readLine();
            List<Integer> numbers = convert2List(headerLine);
            int rotations = numbers.get(0);
            int inputs = numbers.get(1);
            int outputs = numbers.get(2);
            int test_cases = numbers.get(3);
            double avg_fitness = 0;


            for(int i=0; i<test_cases; i++){
                //read line and complile program using input and calculate fitness for single case
                String testCase = br.readLine();
                List<Integer> n = convert2List(testCase);
                List<Integer> inputsList = n.subList(0,inputs);
                List<Integer> outputsList = new ArrayList<>();

                outputsList.addAll(n.subList(inputs, n.size()));
                inputsList.add(0, rotations);
                String input = String.join(" ", inputsList.stream().map(Object::toString).collect(Collectors.toList()));
                saveAndCompile(program, input);
                avg_fitness+=fittnes4Case( outputsList, outputs);
            }
            return avg_fitness/test_cases;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }


    private void saveAndCompile(Program program, String input)  {
        try{
            String program_txt = program.getTreeProgTxt();
//            System.out.println("\n ------- program txt in Bobaro-------\n");
//            System.out.println(program_txt);
//            System.out.println("\n ------- program txt end -------\n");
            CharStream charStream1 = CharStreams.fromString(program_txt);
            BobaroLexer lexer = new BobaroLexer(charStream1);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BobaroParser parser = new BobaroParser(tokens);
            String str = new BobaroVisitor().visit(parser.program());
            StringBuilder sb = new StringBuilder();
            if(program.getVariables()!=null && !program.getVariables().isEmpty()) {

                sb.append("int ");
                boolean first = true;
                for (TokenNode tn : program.getVariables()) {
                    if(!first){
                        sb.append(", ");
                    }
                    sb.append(tn.getToken());
                    first=false;
                }
                sb.append(";");
            }
            String toInsert = sb.toString();
            String searchPhrase = "char *argv[]) {";
            int pos_str = str.indexOf(searchPhrase)+searchPhrase.length();
            str = new StringBuilder(str).insert(pos_str, toInsert).toString();


//            System.out.println("\n ------- program txt in Cpp -------\n");
//            System.out.println(str);
//            System.out.println("\n ------- program txt in Cpp end -------\n");

            try (PrintWriter out = new PrintWriter("/Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/program.cpp")) {
                out.println(str);
            }catch (Exception e){
                e.printStackTrace();
            }

            ProcessBuilder build =
                    new ProcessBuilder("g++", "/Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/program.cpp");

            // create the process
            Process process = build.start();
            process.waitFor();
            ProcessBuilder build2 =
                    new ProcessBuilder("/Users/mikolajborowicz/Documents/Local/ProgramowanieGenetyczne/TinyGP/a.out");

            // create the process
            Process process2 = build2.start();
            process2.waitFor();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printEpoch(){
        System.out.println("Epoch: " + epoch + "score: " + reachedFitness);
    }
    private void printEpochStarted(){
        System.out.println("Epoch: " + epoch + " just started.");
    }
}
