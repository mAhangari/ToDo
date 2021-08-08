package ir.maktab56.ToDo.repository.impl;

import java.util.*;
import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Admin;
import ir.maktab56.ToDo.repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

	public AdminRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}
	
	@Override
	public void save(Admin admin) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(admin);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void update(Admin admin) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(admin);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public List<Admin> findAllById(Collection<Long> ids) {
		EntityManager en = emf.createEntityManager();
		try {
			List<Admin> admins = new ArrayList<>();
			for(Long id: ids) {
				admins.add(findById(id));
			}
			return admins;
		}catch(NoResultException e) {
			return null;
		}finally {
			en.close();
		}
	}
	
	@Override
	public List<Admin> findAll() {
		EntityManager em = emf.createEntityManager();
		try{
			List<Admin> admins = em.createQuery("SELECT * FROM Admin", Admin.class).getResultList();
			return admins;
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
			Admin admin = em.find(Admin.class, id);
			em.remove(admin);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public Admin findById(Long id) {
		EntityManager em = emf.createEntityManager();
		Admin admin = em.find(Admin.class, id);
		em.close();
		return admin;
	}
	
	@Override
	public Boolean existsById(Long id) {
		EntityManager em = emf.createEntityManager();
		if(em.find(Admin.class, id) != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}
	
	@Override
	public <T> boolean checkUsername(T username) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT * FROM Admin AS a WHERE a.username =: Username", Admin.class);
			query.setParameter("Username", username).getSingleResult();
			return true;
		}catch(NoResultException e) {
			return false;
		}finally {
			em.close();
		}
	}
	
	@Override
	public <UT, PT> boolean checkAdminInfo(UT username, PT password) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT * FROM Admin AS a WHERE a.username =: Username AND c.password =: Password", Admin.class); 
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
	public <T> Admin findByUsername(T username) {
		EntityManager em = emf.createEntityManager();
		try {
			Admin admin = em.createQuery("SELECT c FROM Admin AS c WHERE c.username =: Username", Admin.class).setParameter("Username", username).getSingleResult();
			return admin;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}
}
