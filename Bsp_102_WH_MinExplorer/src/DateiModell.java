
import java.util.ArrayList;
import javax.swing.AbstractListModel;


public class DateiModell extends AbstractListModel{
    private ArrayList<Datei> filter = new ArrayList();
    private ArrayList<Datei> gesamt = new ArrayList();
    
    public void addFile(Datei d){
        filter.add(d);
        gesamt.add(d);
        fireIntervalAdded(this, filter.size()-1, filter.size()-1);
    }
    
    @Override
    public int getSize() {
        return filter.size();
    }

    @Override
    public Object getElementAt(int index) {
        return filter.get(index);
    }
    
}
