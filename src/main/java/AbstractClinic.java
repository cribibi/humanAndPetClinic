import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractClinic {
    public Map<Integer, AbstractPatient> currentPatients;

    public abstract void addPatient(AbstractPatient patient);

    public abstract void addBulkPatients(List<AbstractPatient> patients);

    public abstract void removePatientByPatientObject(AbstractPatient patient);

    public abstract void removePatientByPatientId(Integer patientId);

    public abstract void listPatients();

}
