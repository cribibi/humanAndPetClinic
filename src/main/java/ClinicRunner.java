import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClinicRunner {
    public static void main(String[] args) throws IOException, URISyntaxException {

        HumanPatient pacient2 = new HumanPatient(8, "JON", "raceala");
        HumanPatient pacient3 = new HumanPatient(8, "Mihaita", "dureri");
        System.out.println("========================");

        ClinicReader clinicReader = new ClinicFileReader();

        List<AbstractPatient> patients = clinicReader.readPatients();
        System.out.println("List of human patients: "+ patients);
        System.out.println("========================");

        Map<Integer, String> problems = clinicReader.readProblems();
        System.out.println("List of human problems: " + problems);
        System.out.println("========================");

        List<AbstractPatient> petPatients = clinicReader.readPetPatients();
        System.out.println("List of pet patients: "+ petPatients);
        System.out.println("========================");

        Map<Integer, String> petProblems = clinicReader.readPetProblems();
        System.out.println("List of pet problems: " + petProblems);
        System.out.println("========================");

        AbstractClinic clinic = new HumanClinic();
        clinic.addBulkPatients(patients);
        clinic.listPatients();
        System.out.println("lista de pacienti din fisier este printata deasupra");
        System.out.println();

        clinic.addPatient(pacient2);
        clinic.listPatients();
        System.out.println("Am adaugat pacientul2");
        System.out.println();

        clinic.addPatient(pacient3);
        clinic.listPatients();
        System.out.println("Am adaugat pacientul3 dar avea acelasi ID cu pacientul2 si a fost ignorat");
        System.out.println();

        clinic.removePatientByPatientId(1);
        clinic.listPatients();
        System.out.println("Am sters pacientul cu ID-ul 1");
        System.out.println();


        clinic.removePatientByPatientObject(pacient3);
        clinic.listPatients();
        System.out.println("Am sters pacientul3");
        System.out.println();


        clinic.removePatientByPatientObject(patients.get(3));
        clinic.listPatients();
        System.out.println("========================");
        System.out.println();

    }
}
