package ir.maktab56.ToDo.repository.impl;

import java.util.*;
import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.repository.CustomerRepository;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

	public CustomerRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}
	
	@Override
	public void save(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void update(Customer customer) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public List<Customer> findAllById(Collection<Long> ids) {
		EntityManager en = emf.createEntityManager();
		try {
			List<Customer> customers = new ArrayList<>();
			for(Long id: ids) {
				customers.add(findById(id));
			}
			return customers;
		}catch(NoResultException e) {
			return null;
		}finally {
			en.close();
		}
	}
	
	@Override
	public List<Customer> findAll() {
		EntityManager em = emf.createEntityManager();
		try {
			List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
			return customers;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}
	
	@Override
	public void deleteById(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Customer customer = em.find(Customer.class, id);
			em.remove(customer);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public Customer findById(Long id) {
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		em.close();
		return customer;
	}
	
	@Override
	public Boolean existsById(Long id) {
		EntityManager em = emf.createEntityManager();
		if(em.find(Customer.class, id) != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
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
}
