package ir.maktab56.ToDo.base.reposiotry;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import ir.maktab56.ToDo.base.domain.*;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    void save(E e) throws SQLException;

    void update(E e) throws SQLException;

    List<E> findAllById(Collection<ID> ids);

    List<E> findAll() throws SQLException;

    void deleteById(ID id) throws SQLException;

    E findById(ID id) throws SQLException;

    Boolean existsById(ID id) throws SQLException;
}
