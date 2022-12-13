package Backend;

public class TestAdmin {
    
 public static void test1() {
        AdminRole admin = new AdminRole();
        String[] arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        admin.addLibrarian("L1100", "Mariam", "mariam@gmail.com", "Alexandria", "01011845684");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        System.out.println(arrayOfLibrarianUsers[2]);
        admin.removeLibrarian("L1400");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        System.out.println(arrayOfLibrarianUsers[2]);
        admin.removeLibrarian("L1600");
        arrayOfLibrarianUsers = admin.getListOfLibrarians();
        System.out.println("Current number of librarian users  = " + arrayOfLibrarianUsers.length);
        System.out.println(arrayOfLibrarianUsers[3]);
        admin.logout();
    }

    public static void main(String[] args) {
        test1();
    }
}

