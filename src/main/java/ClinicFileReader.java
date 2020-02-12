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

    private List<String> readFileByName(String fileName) throws URISyntaxException, IOException {
        URI file = ClassLoader.getSystemResource(fileName).toURI();
        Path pathOfFile = Paths.get(file);
        List<String> strings = Files.readAllLines(pathOfFile);
        return strings;
    }

    public List<AbstractPatient> readPatients() throws IOException, URISyntaxException {
        ArrayList<AbstractPatient> humanPatients = new ArrayList<>();
        List<String> strings = readFileByName("human_patients.txt");
        Map<Integer, String> problemDescriptionMap = readProblems();

        for (int i = 0; i < strings.size(); i++) {
            String[] fields = strings.get(i).split(",");
            HumanPatient patient = new HumanPatient(Integer.parseInt(fields[0]), fields[1],
                    problemDescriptionMap.get(Integer.parseInt(fields[2])));
            humanPatients.add(patient);
        }
        return humanPatients;
    }

    public Map<Integer, String> readProblems() throws IOException, URISyntaxException {
        Map<Integer, String> humanProblems = new HashMap<>();
        List<String> strings = readFileByName("human_problems.txt");

        for (int i = 0; i < strings.size(); i++) {
            String[] fields = strings.get(i).split(",");
            humanProblems.put(Integer.parseInt(fields[0]), fields[1]);
        }
        return humanProblems;
    }

    public List<AbstractPatient> readPetPatients() throws IOException, URISyntaxException {
        ArrayList<AbstractPatient> petPatients = new ArrayList<>();
        List<String> strings = readFileByName("pet_patients.txt");
        Map<Integer, String> problemDescriptionMap = readPetProblems();

        for (int i = 0; i < strings.size(); i++) {
            String[] fields = strings.get(i).split(",");
            PetPatient pet = new PetPatient(Integer.parseInt(fields[0]), fields[1],
                    problemDescriptionMap.get(Integer.parseInt(fields[2])));
            petPatients.add(pet);
        }
        return petPatients;
    }

    public Map<Integer, String> readPetProblems() throws IOException, URISyntaxException {
        Map<Integer, String> petProblems = new HashMap<>();
        List<String> strings = readFileByName("pet_problems.txt");

        for (int i = 0; i < strings.size(); i++) {
            String[] fields = strings.get(i).split(",");
            petProblems.put(Integer.parseInt(fields[0]), fields[1]);
        }
        return petProblems;
    }
}
