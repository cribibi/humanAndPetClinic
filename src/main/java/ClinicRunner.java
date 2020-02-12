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

        ClinicReader clinicReader = new ClinicFileReader(PatientTypes.HUMAN);

        List<AbstractPatient> patients = clinicReader.readPatients();
        System.out.println("List of human patients: "+ patients);
        System.out.println("========================");

        Map<Integer, String> problems = clinicReader.readProblems();
        System.out.println("List of human problems: " + problems);
        System.out.println("========================");

        ClinicReader clinicReader2 = new ClinicFileReader(PatientTypes.PET);

        List<AbstractPatient> petPatients = clinicReader.readPatients();
        System.out.println("List of human patients: "+ petPatients);
        System.out.println("========================");

        Map<Integer, String> petProblems = clinicReader.readProblems();
        System.out.println("List of human problems: " + petProblems);
        System.out.println("========================");


        AbstractClinic clinic = new HumanClinic();
        clinic.addBulkPatients(patients);
        System.out.println("lista de pacienti din fisier: ");
        clinic.listPatients();
        System.out.println();

        clinic.addPatient(pacient2);
        System.out.println("Am adaugat pacientul2");
        clinic.listPatients();
        System.out.println();

        clinic.addPatient(pacient3);
        System.out.println("Am adaugat pacientul3 dar avea acelasi ID cu pacientul2 si a fost ignorat");
        clinic.listPatients();
        System.out.println();

        clinic.removePatientByPatientId(1);
        System.out.println("Am sters pacientul cu ID-ul 1");
        clinic.listPatients();
        System.out.println();

        clinic.removePatientByPatientObject(pacient3);
        System.out.println("Am sters pacientul3");
        clinic.listPatients();
        System.out.println();

        clinic.removePatientByPatientObject(patients.get(3));
        System.out.println("Am sters pacientul e pe pozitia 3");
        clinic.listPatients();
        System.out.println();

        AbstractClinic clinic2 = new PetClinic();
        clinic2.addBulkPatients(petPatients);
        System.out.println("lista de pet patients din fisier:");
        clinic2.listPatients();
        System.out.println();
    }
}
