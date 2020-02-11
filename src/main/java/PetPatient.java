public class PetPatient extends AbstractPatient {


    public PetPatient(int patientID, String patientName) {
        super(patientID, patientName);
    }

    public PetPatient(int patientID, String patientName, String problemName) {
        super(patientID, patientName, problemName);
    }
}
