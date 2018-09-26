
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.AbstractListModel;

public class DateiModell extends AbstractListModel {

    private ArrayList<Datei> gesamt = new ArrayList();

    public void add(String path) {
        File dir = new File(path);
        for (File f : dir.listFiles()) {
            LocalDateTime changeDate
                    = LocalDateTime
                            .ofEpochSecond(f
                                    .lastModified() / 1000, 0, ZoneOffset.UTC);
            String name = f.getName();
            int groesse = (int) f.length();
            String pathname = f.getAbsolutePath();
            gesamt.add(new Datei(name, pathname, changeDate, groesse));
            fireIntervalAdded(this, gesamt.size() - 1, gesamt.size() - 1);
        }
        sort();
    }

    @Override
    public int getSize() {
        return gesamt.size();
    }

    @Override
    public Object getElementAt(int index) {
        return gesamt.get(index);
    }

    public void goDeeper(int index) {
        File dir = gesamt.get(index);
        if (dir.isDirectory()) {
            gesamt.clear();
            for (File f : dir.listFiles()) {
                String pathname = f.getAbsolutePath();
                String name = f.getName();
                int groesse = (int) f.length();
                LocalDateTime changeDate
                    = LocalDateTime
                            .ofEpochSecond(f
                                    .lastModified() / 1000, 0, ZoneOffset.UTC);
                gesamt.add(new Datei(name, pathname, changeDate, groesse));
                fireIntervalAdded(this, gesamt.size() - 1, gesamt.size() - 1);
            }
        }
        sort();
    }
    
    public void sort(){
        ArrayList<Datei> directories = new ArrayList();
        ArrayList<Datei> files = new ArrayList();
        for (Datei datei : gesamt) {
            if(datei.isDirectory()){
                directories.add(datei);
            }
            else{
                files.add(datei);
            }
        }
        Collections.sort(directories, new FileComparer());
        Collections.sort(files, new FileComparer());
        gesamt.clear();
        gesamt.addAll(directories);
        gesamt.addAll(files);
        fireContentsChanged(this, 0, gesamt.size()-1);
    }

}
