import java.util.List;
import java.util.Map;

public class HumanClinic extends AbstractClinic {

    //public Map<Integer, AbstractPatient> currentPatients;

    public void addPatient(AbstractPatient patient){
        currentPatients.put(patient.patientID, patient);
    }

    public void addBulkPatients(List<AbstractPatient> patients){
        for (int i = 0; i <patients.size() ; i++) {
            addPatient(patients.get(i));
        }
    }

    public void removePatientByPatientObject(AbstractPatient patient){
        currentPatients.values().remove(patient);
    }

    public void removePatientByPatientId(Integer patientId){
        currentPatients.remove(patientId, currentPatients.get(patientId));
    }

    public void listPatients(){
        for (Map.Entry<Integer, AbstractPatient> ap : currentPatients.entrySet()){
            System.out.println(ap.getKey() + " " + ap.getValue().patientName);
        }
    }
}
