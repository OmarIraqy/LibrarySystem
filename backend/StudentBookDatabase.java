package Backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class StudentBookDatabase extends Database {
    private ArrayList<StudentBook> records = new ArrayList<StudentBook>();

    public StudentBookDatabase(String filename) {
        super(filename);
    }

    @Override
    public StudentBook createRecordFrom(String line) {
        String[] tokens = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        String date = tokens[2];
        LocalDate localDate = LocalDate.parse(date, formatter);
        StudentBook STbook = new StudentBook(tokens[0], tokens[1], localDate);
        return STbook;
    }

}
