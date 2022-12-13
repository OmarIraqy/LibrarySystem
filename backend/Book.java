package Backend;

public class Book implements DataType  {
     private String bookId;
    private String title;
    private String authorName;
    private String publisherName;
    private int quantity;

    public Book(String bookId, String title, String authorName, String publisherName, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     @Override
    public String lineRepresentation() {
        String line = "";
        line += this.bookId + ',';
        line += this.title + ',';
        line += this.authorName + ',';
        line += this.publisherName + ',';
        line += this.getQuantity();
        return line;
    }
     @Override
    public String getSearchKey() {
        return this.bookId;
    }
    
}
