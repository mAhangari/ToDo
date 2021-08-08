package ir.maktab56.ToDo.base.reposiotry.impl;

import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.base.reposiotry.BaseRepository;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID>
			implements BaseRepository<E, ID> {
	protected final EntityManagerFactory emf;
	
	public BaseRepositoryImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
