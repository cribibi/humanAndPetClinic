public abstract class AbstractPatient {
    int patientID;
    String patientName;
    String problemName;

    public AbstractPatient(int patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName;
    }

    public int getPatientID() {
        return patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public AbstractPatient(int patientID, String patientName, String problemName) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.problemName = problemName;
    }

    public String getProblemName() {
        return problemName;
    }
}
