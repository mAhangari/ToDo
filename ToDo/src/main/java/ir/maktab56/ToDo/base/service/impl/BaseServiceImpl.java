package ir.maktab56.ToDo.base.service.impl;

import java.util.*;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.base.service.BaseService;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>> implements BaseService<E, ID> {
	protected final R repository;
	
	public BaseServiceImpl(R repository) {
		this.repository = repository;
	}

	@Override
	public void save(E e) {
		repository.save(e);
	}

	@Override
	public void update(E e) {
		repository.update(e);
	}

	@Override
	public List<E> findAllById(Collection<ID> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

	@Override
	public E findById(ID id) {
		return repository.findById(id);
	}

	@Override
	public Boolean existsById(ID id) {
		return repository.existsById(id);
	}
}
