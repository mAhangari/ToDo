package ir.maktab56.ToDo.base.reposiotry;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import ir.maktab56.ToDo.base.domain.*;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    E save(E e);

    List<E> findAllById(Collection<ID> ids);

    List<E> findAll();

	void delete(E e);
    
    E findById(ID id);

    Boolean existsById(ID id);

	EntityManager getEntityManager();
    
}
