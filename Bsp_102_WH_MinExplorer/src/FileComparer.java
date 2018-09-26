
import java.io.File;
import java.util.Comparator;


public class FileComparer implements Comparator<Datei>{

    @Override
    public int compare(Datei d1, Datei d2) {
        return d1.getName().compareTo(d2.getName());
    }
    
}
