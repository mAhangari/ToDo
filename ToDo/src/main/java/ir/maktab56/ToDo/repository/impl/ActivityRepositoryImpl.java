package ir.maktab56.ToDo.repository.impl;

import java.util.*;
import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Activity;
import ir.maktab56.ToDo.repository.ActivityRepository;

public class ActivityRepositoryImpl extends BaseRepositoryImpl<Activity, Long> implements ActivityRepository {

	public ActivityRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void save(Activity activity) {
		if(activity == null)
			return;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(activity);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void saveAll(Collection<Activity> activities) {
		if(activities.isEmpty())
			return;
		for(Activity activity: activities)
			save(activity);
	}

	@Override
	public void update(Activity activity) {
		if(activity == null)
			return;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(activity);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void updateAll(Collection<Activity> activities) {
		if(activities.isEmpty())
			return;
		for(Activity activity: activities)
			update(activity);
	}

	@Override
	public List<Activity> findAllById(Collection<Long> ids) {
		EntityManager en = emf.createEntityManager();
		try {
			List<Activity> activities = new ArrayList<>();
			for(Long id: ids) {
				activities.add(findById(id));
			}
			return activities;
		}catch(NoResultException e) {
			return null;
		}finally {
			en.close();
		}
	}

	@Override
	public List<Activity> findAll() {
		EntityManager em = emf.createEntityManager();
		try{
			List<Activity> activities = em.createQuery("SELECT * FROM Activity", Activity.class).getResultList();
			return activities;
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
		Activity activity = em.find(Activity.class, id);
			em.remove(activity);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Activity findById(Long id) {
		EntityManager em = emf.createEntityManager();
		try{
			Activity activity = em.find(Activity.class, id);
			return activity;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Boolean existsById(Long id) {
		EntityManager em = emf.createEntityManager();
		if(em.find(Activity.class, id) != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}
	
	@Override
	public <T> List<Activity> findByUserId(T id) {
		EntityManager em = emf.createEntityManager();
		try {
			List<Activity> activities = em.createQuery("SELECT a FROM Activity AS a WHERE a.customer = (SELECT c FROM Customer AS c WHERE c.id =: id)", Activity.class).setParameter("id", id).getResultList();
			return activities;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

}
