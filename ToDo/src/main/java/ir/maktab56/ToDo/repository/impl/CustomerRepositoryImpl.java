package ir.maktab56.ToDo.repository.impl;

import java.sql.SQLException;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.repository.CustomerRepository;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long> implements CustomerRepository {

	public CustomerRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}

	public void save(Customer customer) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(customer);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Customer customer) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(customer);
		em.getTransaction().commit();
		em.close();
	}

	public List<Customer> findAllById(Collection<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> findAll() throws SQLException {
		EntityManager em = emf.createEntityManager();
		List<Customer> customers = em.createQuery("SELECT * FROM customer", Customer.class).getResultList();
		em.close();
		return customers;
	}

	public void deleteById(Long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Customer customer = em.find(Customer.class, id);
			em.remove(customer);
		em.getTransaction().commit();
		em.close();
	}

	public Customer findById(Long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		em.close();
		return customer;
	}

	public Boolean existsById(Long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		if(em.find(Customer.class, id) != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}
}
