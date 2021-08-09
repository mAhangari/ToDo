package ir.maktab56.ToDo.base.reposiotry;

import java.util.Collection;
import java.util.List;

import ir.maktab56.ToDo.base.domain.*;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    void save(E e);

    void update(E e);

    List<E> findAllById(Collection<ID> ids);

    List<E> findAll();

    void deleteById(ID id);

    E findById(ID id);

    Boolean existsById(ID id);
    
}
