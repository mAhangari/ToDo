package ir.maktab56.ToDo.repository.impl;

import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.repository.CustomerRepository;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

	public CustomerRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}
	
	@Override
	public <T> boolean checkUsername(T username) {
		EntityManager em = emf.createEntityManager();
		try{
			Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.username =: Username", Customer.class);
			query.setParameter("Username", username).getSingleResult();		
			return true;
		}catch(NoResultException e) {
			return false;
		}finally {
			em.close();
		}
	}
	
	@Override
	public <UT, PT> boolean checkCustomerInfo(UT username, PT password) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Customer AS c WHERE c.username =: Username AND c.password =: Password", Customer.class); 
			query.setParameter("Username", username);
			query.setParameter("Password", password);
			query.getSingleResult();
			return true;
		}catch(NoResultException e) {
			return false;
		}finally{
			em.close();
		}
	}

	@Override
	public <T> Customer findByUsername(T username) {
		EntityManager em = emf.createEntityManager();
		try {
			Customer customer = em.createQuery("SELECT c FROM Customer AS c WHERE c.username =: Username", Customer.class).setParameter("Username", username).getSingleResult();
			return customer;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Class<Customer> getEntityClass() {
		return Customer.class;
	}
}
