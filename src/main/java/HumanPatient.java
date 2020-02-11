import java.util.ArrayList;
import java.util.List;

public class HumanPatient extends AbstractPatient {

    public HumanPatient(int patientID, String patientName) {
        super(patientID, patientName);
    }

    public HumanPatient(int patientID, String patientName, String problemName) {
        super(patientID, patientName, problemName);
        System.out.println("Human patient "+patientName+" suffering from "+ problemName+" has been added. Get well "+patientName+"!");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HumanPatient{");
        sb.append("patientID=").append(patientID);
        sb.append(", patientName='").append(patientName).append('\'');
        sb.append(", problemName='").append(problemName).append('\'');
        sb.append('}');
        return sb.toString();
    }




}
