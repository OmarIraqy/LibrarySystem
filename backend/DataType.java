package Backend;

import java.time.LocalDate;

interface DataType {
     String lineRepresentation();
     String getSearchKey();

     default LocalDate getBorrowDate()
     {
         return null;
     }

    default int getQuantity()
    {
        return 0;
    }
    default void setQuantity(int quantity)
    {

    }

    
}
