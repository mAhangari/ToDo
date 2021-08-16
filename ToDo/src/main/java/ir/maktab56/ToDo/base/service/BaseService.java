package ir.maktab56.ToDo.base.service;

import java.util.Collection;
import java.util.List;
import ir.maktab56.ToDo.base.domain.BaseEntity;

public interface BaseService<E extends BaseEntity<ID>, ID> {
	
	E save(E e);

    List<E> findAllById(Collection<ID> ids);

    List<E> findAll();

    void delete(E e);

    E findById(ID id);

    Boolean existsById(ID id);
    
}
