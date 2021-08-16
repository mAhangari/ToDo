package ir.maktab56.ToDo.base.reposiotry.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.base.reposiotry.BaseRepository;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID>
			implements BaseRepository<E, ID> {
	
	protected final EntityManagerFactory emf;
	protected EntityManager em;
	
	public BaseRepositoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public abstract Class<E> getEntityClass();

	@Override
	public E save(E e) {
		if(e.getId() == null) {
			em.persist(e);
			return e;
		}else {
			em.merge(e);
			return e;
		}
	}

	@Override
	public List<E> findAllById(Collection<ID> ids) {
		
		List<E> elements = new ArrayList<>();
		for(ID id: ids) {
			elements.add(findById(id));
		}
		return elements;
	}

	@Override
	public List<E> findAll() {
		return em.createQuery("FROM " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
	}

	@Override
	public void delete(E e) {
		em.remove(e);
	}

	@Override
	public E findById(ID id) {	
		return em.find(getEntityClass(), id);
	}

	@Override
	public Boolean existsById(ID id) {
		return em.createQuery(
				"SELECT COUNT(id) FROM " + getEntityClass().getSimpleName() +
				"WHERE id =: id"
				, Long.class
				).setParameter("id", id).getSingleResult() == 1L;
	}
	
	@Override
	public EntityManager getEntityManager() {
		em = emf.createEntityManager();
		return em;
	}
}
