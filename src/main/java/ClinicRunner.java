import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClinicRunner {
    public static void main(String[] args) throws IOException, URISyntaxException {

        //HumanPatient pacient1=new HumanPatient(1,"mirabela");
        HumanPatient pacient2 = new HumanPatient(2, "jon", "raceala");
        HumanPatient pacient3 = new HumanPatient(2, "jony", "dureri");

        ClinicReader clinicReader = new ClinicFileReader();
        List<AbstractPatient> patients = clinicReader.readPatients();
        System.out.println(patients);

        ClinicReader clinicReader2 = new ClinicFileReader();
        Map<Integer, String> problems = clinicReader.readProblems();
        System.out.println(problems);


//        AbstractClinic clinic = new HumanClinic();
//        clinic.addBulkPatients(patients);
//        clinic.listPatients();
    }
}
