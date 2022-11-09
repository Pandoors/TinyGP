package serialisation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import model.Node;
import model.Program;
import model.tokenNode.TokenNode;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Serlialiser {

    public void serialiseToJson(Program program){

        List<TokenPOJO> tokens = new ArrayList<>();
        List<TokenNode> tkns = new ArrayList<>();

        for (Node n : program.getAllNodesForSerial()){
            tkns.add((TokenNode) n);
        }

        tkns.forEach(t -> tokens.add(new TokenPOJO(t.getName(), t.getToken())));



    }

    public static void main(String[] args) {
        Serlialiser s = new Serlialiser();
        s.serialiseToJson(new Program());
    }
}
