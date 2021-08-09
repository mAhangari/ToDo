package ir.maktab56.ToDo.util;

import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.repository.impl.*;
import ir.maktab56.ToDo.service.impl.*;

public class ApplicationContext {
	
	public static EntityManagerFactory emf = HibernateUtil.getEntityMangerFactory();
	
	public static CustomerRepositoryImpl customerRepo = new CustomerRepositoryImpl(emf);
	public static CustomerServiceImpl customerServ = new CustomerServiceImpl(customerRepo);
	
	public static AdminRepositoryImpl adminRepo = new AdminRepositoryImpl(emf);
	public static AdminServiceImpl adminServ = new AdminServiceImpl(adminRepo);
	
	public static WalletRepositoryImpl walletRepo = new WalletRepositoryImpl(emf);
	public static WalletServiceImpl walletServ = new WalletServiceImpl(walletRepo);
	
	public static ActivityRepositoryImpl activityRepo = new ActivityRepositoryImpl(emf);
	public static ActivityServiceImpl activityServ = new ActivityServiceImpl(activityRepo);

	public static Menu menu = new Menu();
	public static CheckInputInformation chInInformation = new CheckInputInformation();	
}

