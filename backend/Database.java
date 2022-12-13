package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database {

    private ArrayList<DataType> records = new ArrayList<DataType>();
    private String filename;

    public Database(String filename) {
        this.filename = filename;
    }

    public void readFromFile() {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                insertRecord(createRecordFrom(sc.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public abstract DataType createRecordFrom(String line);

    public ArrayList<DataType> returnAllRecords() {
        return records;
    }

    public boolean insertRecord(DataType record) {
        if (!(contains(record.getSearchKey()))) {
            this.records.add(record);
            return true;
        }
        return false;
    }

    public boolean contains(String key) {
        for (int i = 0; i < this.records.size(); i++) {
            if (this.records.get(i).getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public DataType getRecord(String key) {
        int i;
        for (i = 0; i <= records.size(); i++) {
            if (this.records.get(i).getSearchKey().equals(key)) {
                return this.records.get(i);
            }
        }
        return null;
    }

    public boolean deleteRecord(String key){
        for(int i=0;i<records.size();i++)
        {
            if (contains(key)) {
                Object record = getRecord(key);
                this.records.remove(record);
                return true;
            }
        }
        return false;
    }

    public void saveToFile() {
        try {
            int i;
            FileWriter fw = new FileWriter(filename);
            for (i = 0; i < records.size() - 1; i++) {
                fw.write(records.get(i).lineRepresentation());
                fw.write("\n");
            }
            if (records.size()==0) {
                fw.close();
            }
            else{
                fw.write(records.get(i).lineRepresentation());
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error Writing in File");

        }

    }
}
