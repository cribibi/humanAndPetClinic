import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanClinic extends AbstractClinic {

    Map<Integer, AbstractPatient> currentPatients = new HashMap<>();
    //aveam nullpoint exception deoarece mapu-ul meu era null, trebuia sa instantiez Map-ul

    public void addPatient(AbstractPatient patient) {
        if (patient == null) throw new IllegalArgumentException("that patient is null");
        else if (!currentPatients.containsKey(patient.patientID)) {
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
