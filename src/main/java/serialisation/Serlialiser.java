package serialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.NoArgsConstructor;
import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@NoArgsConstructor
public class Serlialiser {

    public void serialiseToJson(Program program){

        List<TokenPOJO> tokens = new ArrayList<>();
        List<TokenNode> tkns = new ArrayList<>();

        for (Node n : program.getAllNodesForSerial()){
            tkns.add((TokenNode) n);
        }

        tkns.forEach(t -> tokens.add(new TokenPOJO(t.getName(), t.getToken())));

        Gson gson = new Gson();
        String response = gson.toJson(tokens);

        System.out.println(response);
        Random r = new Random();

        String path = "src/main/java/serialisation/output/"  + "tree_" + r.nextInt()  + ".json";

        try {
            Files.write(Paths.get(path), response.getBytes());
            System.out.println("Successfully wrote to the file: " + path);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public List<TokenPOJO> unserialiseJson(String src){

        try {
            return new Gson().fromJson(new FileReader("src/main/java/serialisation/output/tree_13210333.json"), new TypeToken<ArrayList<TokenPOJO>>() {}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }

    public static void main(String[] args) {
        Serlialiser s = new Serlialiser();
        s.serialiseToJson(new Program());
      List<TokenPOJO> tokenPOJOS =  s.unserialiseJson("src/main/java/serialisation/output/tree_13210333.json");

      tokenPOJOS.forEach(t -> System.out.println(t.getName() + " with value: " + t.getValue()));

    }
}
