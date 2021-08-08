package ir.maktab56.ToDo.base.reposiotry.impl;

import java.sql.Connection;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.base.reposiotry.BaseRepository;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID>
			implements BaseRepository<E, ID>{
	protected final Connection connection;
	
	public BaseRepositoryImpl(Connection connection) {
		this.connection = connection;
	}
}
