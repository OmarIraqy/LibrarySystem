package Backend;

import java.util.ArrayList;


public class LibrarianUserDatabase extends Database {
     private ArrayList<LibrarianUser> records = new ArrayList<LibrarianUser>();

    public LibrarianUserDatabase(String filename) {
        super(filename);
    }

     @Override
    public LibrarianUser createRecordFrom(String line) {
        String[] data = line.split(",");
        LibrarianUser x = new LibrarianUser(data[0], data[1], data[2], data[3], data[4]);
        return x;
    }

}
