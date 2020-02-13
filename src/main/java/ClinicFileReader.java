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

    private final PatientTypes types;

    public ClinicFileReader(PatientTypes types) {
        this.types = types;
    }

    private List<String> readFileByName(String fileName) throws URISyntaxException, IOException {
        URI file = ClassLoader.getSystemResource(fileName).toURI();
        Path pathOfFile = Paths.get(file);
        List<String> strings = Files.readAllLines(pathOfFile);
        return strings;
    }

    public List<AbstractPatient> readPatients() throws IOException, URISyntaxException {
        ArrayList<AbstractPatient> patients = new ArrayList<>();
        List<String> strings = readFileByName(types.getPatientsFiles());
        Map<Integer, String> problemDescriptionMap = readProblems();

        if (types.equals(PatientTypes.HUMAN)) {
            for (int i = 0; i < strings.size(); i++) {
                String[] fields = strings.get(i).split(",");

                AbstractPatient patient = new HumanPatient(Integer.parseInt(fields[0]), fields[1],
                        problemDescriptionMap.get(Integer.parseInt(fields[2])));
                patients.add(patient);
            }
            return patients;
        } else {
            for (int i = 0; i < strings.size(); i++) {
                String[] fields = strings.get(i).split(",");
                AbstractPatient patient = new PetPatient(Integer.parseInt(fields[0]), fields[1],
                        problemDescriptionMap.get(Integer.parseInt(fields[2])));
                patients.add(patient);
            }
            return patients;
        }
    }

    public Map<Integer, String> readProblems() throws IOException, URISyntaxException {
        Map<Integer, String> problems = new HashMap<>();
        List<String> strings = readFileByName(types.getProblemsFiles());

        for (int i = 0; i < strings.size(); i++) {
            String[] fields = strings.get(i).split(",");
            problems.put(Integer.parseInt(fields[0]), fields[1]);
        }
        return problems;
    }
}
