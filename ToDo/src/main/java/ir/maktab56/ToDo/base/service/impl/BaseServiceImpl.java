package ir.maktab56.ToDo.base.service.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.base.service.BaseService;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>> implements BaseService<E, ID> {
	protected final R repository;
	
	public BaseServiceImpl(R repository) {
		this.repository = repository;
	}

	@Override
	public E save(E e) {
		EntityManager em = repository.getEntityManager();
		em.getTransaction().begin();
		e = repository.save(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}

	@Override
	public List<E> findAllById(Collection<ID> ids) {
		try {
			return repository.findAllById(ids);
		}catch(NoResultException e) {
			return null;
		}
	}

	@Override
	public List<E> findAll() {
		EntityManager em = repository.getEntityManager();
		try{
			return repository.findAll();
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public void delete(E e) {
		EntityManager em = repository.getEntityManager();
		em.getTransaction().begin();
			repository.delete(e);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public E findById(ID id) {
		EntityManager em = repository.getEntityManager();
		try{
			return repository.findById(id);
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Boolean existsById(ID id) {
		return repository.existsById(id);
	}
}
