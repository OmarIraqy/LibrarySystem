package Backend;

import constants.FileNames;
import java.time.LocalDate;
import java.time.Period;

public class LibrarianRole implements FileNames {
    
    
    BookDatabase booksDatabase= new BookDatabase(BOOKS_FILENAME);
    StudentBookDatabase sBDatabase = new StudentBookDatabase(STUDENTSBOOKS_FILENAME);

    public LibrarianRole() {
        booksDatabase.readFromFile();
        sBDatabase.readFromFile();
    }

    public boolean addBook(String id, String title, String authorName, String publisherName, int quantity) {
        Book book = new Book(id, title, authorName, publisherName, quantity);
        if(booksDatabase.insertRecord(book))
        {
            return true;
        }
        else 
            return false;
    }

    public String [] getListOfBooks() {
        String [] tempRecords=new String[booksDatabase.returnAllRecords().size()];
        for(int i=0;i<booksDatabase.returnAllRecords().size();i++)
        {
            tempRecords[i]= ((Book)booksDatabase.returnAllRecords().get(i)).lineRepresentation();
        }
        return tempRecords;
    }

    public String [] getListOfBorrowingOperations() {
        String [] tempRecords=new String[sBDatabase.returnAllRecords().size()];
        for(int i=0;i<sBDatabase.returnAllRecords().size();i++)
        {
            tempRecords[i] = ((StudentBook)sBDatabase.returnAllRecords().get(i)).lineRepresentation();
        }
        return tempRecords;
    }

    public int borrowBook(String studentId, String bookId, LocalDate borrowDate) {
        for(int i = 0; i < sBDatabase.returnAllRecords().size(); i++) {
            if (sBDatabase.contains(studentId+","+bookId)) {
                return 1;
            }
        }
        for (int i = 0; i < booksDatabase.returnAllRecords().size(); i++){
            if (booksDatabase.getRecord(bookId).getQuantity()<=0){
                return 0;
            }
        }
        booksDatabase.getRecord(bookId).setQuantity((booksDatabase.getRecord(bookId).getQuantity()) - 1);
        StudentBook tempStudentBook=new StudentBook(studentId,bookId,borrowDate);
        sBDatabase.insertRecord(tempStudentBook);
        return 2;
    }

    public double returnBook(String studentId, String bookId, LocalDate returnDate) {
        boolean flag = false;
        int i;
        double fee = 0;
        for (i = 0; i < sBDatabase.returnAllRecords().size() && flag == false; i++) {
            if (sBDatabase.contains(studentId+","+bookId)) {
                booksDatabase.getRecord(bookId).setQuantity((booksDatabase.getRecord(bookId).getQuantity()) + 1);
                Period diff = Period.between(sBDatabase.getRecord(studentId+","+bookId).getBorrowDate(), returnDate);
                if (diff.getDays() < 7) {
                    fee = 0;
                } else {
                    fee = (diff.getDays() - 7) * 0.5;
                }
                String key = studentId + "," + bookId;
                sBDatabase.deleteRecord(key);
                flag = true;
            }
        }
        return fee;
    }
    public void logout() {
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
    
}
