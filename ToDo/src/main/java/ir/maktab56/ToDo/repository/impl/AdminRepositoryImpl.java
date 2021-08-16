package ir.maktab56.ToDo.repository.impl;

import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Admin;
import ir.maktab56.ToDo.repository.AdminRepository;

public class AdminRepositoryImpl extends BaseRepositoryImpl<Admin, Long> implements AdminRepository {

	public AdminRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
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
			Admin admin = em.createQuery("SELECT a FROM Admin AS a WHERE a.username =: Username", Admin.class).setParameter("Username", username).getSingleResult();
			return admin;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}
	
	@Override
	public Class<Admin> getEntityClass() {
		return Admin.class;
	}
}
