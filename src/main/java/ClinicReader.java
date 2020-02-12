import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public interface ClinicReader {

    //in interface nu am corpul metodei, nu am acolade
    List<AbstractPatient> readPatients() throws IOException, URISyntaxException;
    Map<Integer, String> readProblems() throws IOException, URISyntaxException;
    List<AbstractPatient> readPetPatients() throws IOException, URISyntaxException;
    Map<Integer, String> readPetProblems() throws IOException, URISyntaxException;

}
