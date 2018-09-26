
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datei extends File {

    private String name;
    private LocalDateTime changeDate;
    private int groesse;

    public Datei(String name, String pathname, LocalDateTime changeDate, int groesse) {
        super(name);
        this.name = name;
        this.changeDate = changeDate;
        this.groesse = groesse;
    }

    @Override
    public String toString() {
        return String
                .format("%-30s %-30s %-10s KB",
                        name, changeDate
                                .format(DateTimeFormatter
                                        .ofPattern("dd.MM.yyyy HH:mm")),
                        groesse);
    }

}
