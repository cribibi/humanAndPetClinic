import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PatientTypes {

    HUMAN("human_patient.txt", "human_problems.txt"),
    PET("pet_patient.txt", "pet_problems.txt");

    private final String patientsFiles;
    private final String problemsFiles;

    PatientTypes(String patientsFiles, String problemsFiles) {
        this.patientsFiles = patientsFiles;
        this.problemsFiles = problemsFiles;
    }

    public String getPatientsFiles() {
        return patientsFiles;
    }

    public String getProblemsFiles() {
        return problemsFiles;
    }
}

