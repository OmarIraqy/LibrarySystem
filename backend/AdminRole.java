package Backend;

import constants.FileNames;
import static constants.FileNames.LIBRARIANS_FILENAME;

public class AdminRole implements FileNames {
    
    LibrarianUserDatabase database=new LibrarianUserDatabase(LIBRARIANS_FILENAME);

    public AdminRole(){
        database.readFromFile();
    }

    public boolean addLibrarian (String librarianId,String name,String email,String address,String phoneNumber){
        LibrarianUser x=new LibrarianUser(librarianId,name,email,address,phoneNumber);
        return database.insertRecord(x);
    }


    public String[] getListOfLibrarians()
    {
        String [] tempRecords=new String[database.returnAllRecords().size()];
        for(int i=0;i<database.returnAllRecords().size();i++)
        {
            tempRecords[i] = ((LibrarianUser)database.returnAllRecords().get(i)).lineRepresentation();
        }
        return tempRecords;
    }


    public boolean removeLibrarian(String key)
    {
        return database.deleteRecord(key);
    }

    public void logout()
    {
        database.saveToFile();
    }
    
}
