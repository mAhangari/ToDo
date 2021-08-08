package ir.maktab56.ToDo.base.service.impl;

import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.base.service.BaseService;

public abstract class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>> implements BaseService<E, ID> {
	protected final R repository;
	
	public BaseServiceImpl(R repository) {
		this.repository = repository;
	}
}
