package ir.maktab56.ToDo;

import java.sql.SQLException;
import ir.maktab56.ToDo.util.*;

public class App {
    public static void main( String[] args ) throws SQLException {
    	ApplicationContext.menu.showMenu();
    	ApplicationContext.emf.close();
    }
}
