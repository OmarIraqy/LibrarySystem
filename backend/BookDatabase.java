package Backend;

import java.util.ArrayList;

public class BookDatabase extends Database {
    private ArrayList<Book> records = new ArrayList<Book>();

    public BookDatabase(String filename) {
        super(filename);
    }

    public Book createRecordFrom(String line) {

        String[] tokens = line.split(",");
        int quantity = Integer.parseInt(tokens[4]);
        Book book = new Book(tokens[0], tokens[1], tokens[2], tokens[3], quantity);
        return book;

    }
}
