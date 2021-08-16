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
	public List<Activity> saveAll(Collection<Activity> activities) {
		if(activities.isEmpty())
			return null;
		for(Activity activity: activities)
			save(activity);
		return (List<Activity>) activities;
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

	@Override
	public Class<Activity> getEntityClass() {
		return Activity.class;
	}

}
