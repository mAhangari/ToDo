package ir.maktab56.ToDo;

// import java.sql.Date;
import java.sql.SQLException;
// import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.util.*;


public class App {
    public static void main( String[] args ) throws SQLException {
    	ApplicationContext.getConnection();
    	ApplicationContext.menu.showMenu();
    	//Customer customer1 = new Customer(1l, false, "mAhangari", "Mori1995", "2150382342", "Morteza", "Ahangari", "morteza_1993@yahoo.com", "09116425909", "Customer", true, Date.valueOf("1995-02-16"));
    	ApplicationContext.emf.close();
    }
}
