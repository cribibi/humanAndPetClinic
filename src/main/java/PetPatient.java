import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class PetPatient extends AbstractPatient {


    public PetPatient(int patientID, String patientName) throws IOException, URISyntaxException {
        super(patientID, patientName);
    }


    public PetPatient(int patientID, String patientName, String problemName) throws IOException, URISyntaxException {
        super(patientID, patientName, problemName);
        System.out.println("PET patient "+patientName+", suffering from "+
                problemName+", has been added. Get well dear "+patientName+"!");

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PetPatient{");
        sb.append("patientID=").append(patientID);
        sb.append(", patientName='").append(patientName).append('\'');
        sb.append(", problemName='").append(problemName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
