import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanClinic extends AbstractClinic {

    Map<Integer, AbstractPatient> currentPatients = new HashMap<>();
    private ClinicFileReader clinicReader = new ClinicFileReader(PatientTypes.HUMAN);
    Map<Integer, String> problems = clinicReader.readProblems();

    public HumanClinic() throws IOException, URISyntaxException {
    }

    //aveam nullpoint exception deoarece mapu-ul meu era null, trebuia sa instantiez Map-ul
    //trebuie instantiat ca HashMap, nu ca Map
    public void addPatient(AbstractPatient patient) {
        if (patient == null) throw new IllegalArgumentException("that patient is null");

        else if (currentPatients.containsKey(patient.patientID)){
            System.out.println("That ID is already taken. We can't add the patient");
        }
        else if (!problems.containsValue(patient.problemName)){
            System.out.println("We don't know this type of problem. The possible problems are:"+problems);
        }else {
            currentPatients.put(patient.patientID, patient);
        }
    }

    public void addBulkPatients(List<AbstractPatient> patients) {
        for (int i = 0; i < patients.size(); i++) {
            addPatient(patients.get(i));
        }
    }

    public void removePatientByPatientObject(AbstractPatient patient) {
        currentPatients.values().remove(patient);

    }

    public void removePatientByPatientId(Integer patientId) {
        currentPatients.remove(patientId, currentPatients.get(patientId));

    }


    public void listPatients() {
        for (Map.Entry<Integer, AbstractPatient> ap : currentPatients.entrySet()) {
            System.out.println(ap.getKey() + " " + ap.getValue().patientName);
        }
    }
}
