
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


public class FileListRenderer implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object e, int i, boolean isSelected, boolean cellHasFocus) {
        if(e instanceof Datei){
            Datei item = (Datei) e;
            Component c = null;
            JLabel lb = null;
            if(item.isDirectory()){
                lb = new JLabel(item.getName());
                lb.setOpaque(true);
                c = lb;
                c.setForeground(Color.RED);
            }
            else{
                lb = new JLabel(item.toString());
                lb.setOpaque(true);
                c = lb;
                c.setForeground(Color.BLUE);
            }
            
            if(isSelected){
                c.setBackground(Color.LIGHT_GRAY);
            }
            else{
                c.setBackground(Color.WHITE);
            }
            return c;
        }
        return new JLabel("???");
    }
    
}
