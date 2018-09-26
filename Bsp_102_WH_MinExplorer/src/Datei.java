
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datei extends File {

    private String name;
    private LocalDateTime changeDate;
    private int groesse;
    private String detail;

    public Datei(String name, String pathname,
            LocalDateTime changeDate, int groesse, String detail) {
        super(name);
        this.name = name;
        this.changeDate = changeDate;
        this.groesse = groesse;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return String
                .format("%-30s %-30s %-5s %2s %s",
                        name, changeDate
                                .format(DateTimeFormatter
                                        .ofPattern("dd.MM.yyyy HH:mm")),
                        groesse, "KB", detail);
    }

}
