import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetClinic extends AbstractClinic {

    Map<Integer, AbstractPatient> currentPatients = new HashMap<>();
    ClinicFileReader clinicPet =new ClinicFileReader(PatientTypes.PET);
    Map<Integer, String> petProblems= clinicPet.readProblems();

    public PetClinic() throws IOException, URISyntaxException {
    }
    //trebuie instantiat ca HashMap, si nu ca Map

    @Override
    public void addPatient(AbstractPatient patient) {
        if (patient == null) throw new IllegalArgumentException("that patient is null");
        else if (!currentPatients.containsKey(patient.patientID)) {
            currentPatients.put(patient.patientID, patient);
        }
        if (!petProblems.containsValue(patient.problemName)){
            petProblems.put(petProblems.size()+1, patient.problemName);
        }
    }

    @Override
    public void addBulkPatients(List<AbstractPatient> patients) {
        for (int i = 0; i < patients.size(); i++) {
            addPatient(patients.get(i));
        }

    }

    @Override
    public void removePatientByPatientObject(AbstractPatient patient) {
        currentPatients.values().remove(patient);
    }

    @Override
    public void removePatientByPatientId(Integer patientId) {
        currentPatients.remove(patientId, currentPatients.get(patientId));
    }

    @Override
    public void listPatients() {
        for (Map.Entry<Integer, AbstractPatient> ap : currentPatients.entrySet()) {
            System.out.println(ap.getKey() + " " + ap.getValue().patientName);
        }

    }
    public void listProblems() {
        for (Map.Entry<Integer, String> ap : petProblems.entrySet()) {
            System.out.println(ap.getKey() + " " + ap.getValue());
        }

    }
}
