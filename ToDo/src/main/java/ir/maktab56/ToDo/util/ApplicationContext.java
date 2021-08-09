package ir.maktab56.ToDo.util;

import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.repository.impl.AdminRepositoryImpl;
import ir.maktab56.ToDo.repository.impl.CustomerRepositoryImpl;
import ir.maktab56.ToDo.service.impl.AdminServiceImpl;
import ir.maktab56.ToDo.service.impl.CustomerServiceImpl;
import ir.maktab56.ToDo.service.impl.Menu;

public class ApplicationContext {
	
	public static EntityManagerFactory emf = HibernateUtil.getEntityMangerFactory();
	public static CustomerRepositoryImpl customerRepo = new CustomerRepositoryImpl(emf);
	public static CustomerServiceImpl customerServ = new CustomerServiceImpl(customerRepo);
	public static AdminRepositoryImpl adminRepo = new AdminRepositoryImpl(emf);
	public static AdminServiceImpl adminServ = new AdminServiceImpl(adminRepo);

	public static Menu menu = new Menu();
	public static CheckInputInformation chInInformation = new CheckInputInformation();	
}

