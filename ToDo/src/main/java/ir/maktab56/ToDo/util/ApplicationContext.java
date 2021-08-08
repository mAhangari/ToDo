package ir.maktab56.ToDo.util;

import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.repository.impl.AdminRepositoryImpl;
import ir.maktab56.ToDo.repository.impl.CustomerRepositoryImpl;
import ir.maktab56.ToDo.service.impl.AdminServiceImpl;
import ir.maktab56.ToDo.service.impl.CustomerServiceImpl;
import ir.maktab56.ToDo.service.impl.Menu;

public class ApplicationContext {
	
	public static final EntityManagerFactory emf = HibernateUtil.getEntityMangerFactory();
	public static CustomerRepositoryImpl customerRepo;
	public static CustomerServiceImpl customerServ;
	public static AdminRepositoryImpl adminRepo;
	public static AdminServiceImpl adminServ;

	public static Menu menu = new Menu();
	public static CheckInputInformation chInInformation = new CheckInputInformation();
	
	public static void getConnection() {
		loadAll();
	}
	
	private static void loadAll() {
		customerRepo = new CustomerRepositoryImpl(emf);
		customerServ = new CustomerServiceImpl(customerRepo);
		
		adminRepo = new AdminRepositoryImpl(emf);
		adminServ = new AdminServiceImpl(adminRepo);
	}
	
}

