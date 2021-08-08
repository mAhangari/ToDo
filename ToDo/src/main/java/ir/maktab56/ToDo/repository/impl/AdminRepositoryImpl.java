package ir.maktab56.ToDo.repository.impl;

import java.sql.SQLException;
import java.util.*;
import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Admin;
import ir.maktab56.ToDo.repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

	public AdminRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}

	public void save(Admin admin) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(admin);
		em.getTransaction().commit();
		em.close();
	}

	public void update(Admin admin) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(admin);
		em.getTransaction().commit();
		em.close();
	}

	public List<Admin> findAllById(Collection<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> findAll() throws SQLException {
		EntityManager em = emf.createEntityManager();
		List<Admin> admins = em.createQuery("SELECT * FROM admin", Admin.class).getResultList();
		em.close();
		return admins;
	}

	public void deleteById(Long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Admin admin = em.find(Admin.class, id);
			em.remove(admin);
		em.getTransaction().commit();
		em.close();
	}

	public Admin findById(Long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		Admin admin = em.find(Admin.class, id);
		em.close();
		return admin;
	}

	public Boolean existsById(Long id) throws SQLException {
		EntityManager em = emf.createEntityManager();
		if(em.find(Admin.class, id) != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}
}
