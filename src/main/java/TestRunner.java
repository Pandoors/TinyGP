import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import visitor.BobaroLexer;
import visitor.BobaroParser;
import visitor.own.BobaroVisitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestRunner {



        public static void main(String[] args) throws IOException {

            System.out.println("Enter java code file location: ");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String inputFile = reader.readLine();
            System.out.println(inputFile);
            CharStream in = CharStreams.fromFileName(inputFile);
            BobaroLexer lexer = new BobaroLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BobaroParser parser = new BobaroParser(tokens);

            String str = new BobaroVisitor().visit(parser.program());
            System.out.println(str);

            try (PrintWriter out = new PrintWriter("output.txt")) {
                out.println(str);
            }
        }


}
