package Backend;


public class LibrarianUser implements DataType {
    private String librarianId ,name ,email ,address , phoneNumber;

    public String getLibrarianId() {
        return librarianId;
    }

    public LibrarianUser(String librarianId, String name, String email, String address, String phoneNumber) {
        this.librarianId = librarianId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        String x= librarianId+","+name+","+email+","+address+","+phoneNumber;
        return x;
    }
    @Override
    public String getSearchKey() {
        return librarianId;
    }

}
