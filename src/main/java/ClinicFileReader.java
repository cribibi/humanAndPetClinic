import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClinicFileReader implements ClinicReader {

    public List<AbstractPatient> readPatients() throws IOException, URISyntaxException{
        List<String> strings = readFileByName("human_patients.txt");
        ArrayList<AbstractPatient> patients =new ArrayList<>();

        for (int i = 0; i <strings.size() ; i++) {
            String[] fields = strings.get(i).split(",");
            HumanPatient human=new HumanPatient(Integer.parseInt(fields[0]), fields[1], fields[2]);
            patients.add(human);
            System.out.println("Human patient "+ fields[1]+"suffering from "+fields[2] +" added. Get well "+ fields[1]+"!");
        }
        return patients;
    }


    public Map<Integer, String> readProblems() throws IOException, URISyntaxException {
        List<String> strings = readFileByName("human_problems.txt");
        Map<Integer, String> problems =new HashMap<>();
        for (int i = 0; i <strings.size() ; i++) {
            String[] fields = strings.get(i).split(",");
            problems.put(Integer.parseInt(fields[0]), fields[1]);
            System.out.println("Human problem with ID: "+ fields[0]+", called "+fields[1] +" added.");
        }
        return problems;
    }

    private List<String> readFileByName(String fileName) throws URISyntaxException, IOException {
        URI file = ClassLoader.getSystemResource(fileName).toURI();
        Path pathOfFile = Paths.get(file);
        List<String> strings = Files.readAllLines(pathOfFile);
        return strings;
    }



}
