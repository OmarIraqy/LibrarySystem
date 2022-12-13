package Backend;

import java.time.LocalDate;

public class StudentBook implements DataType{
    
    private String studentId;
    private String bookId;
    private LocalDate borrowDate;

    public StudentBook(String studentId, String bookId, LocalDate borrowDate) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getBookId() {
        return bookId;
    }

    @Override
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    @Override
    public String lineRepresentation() {
        String line = "";
        line += this.studentId + ',';
        line += this.bookId + ',';
        line += this.borrowDate;
        return line;
    }
    @Override
    public String getSearchKey() {
        return this.studentId + "," + this.bookId;
    }
}
