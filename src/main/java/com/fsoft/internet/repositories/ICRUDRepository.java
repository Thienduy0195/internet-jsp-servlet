package com.fsoft.internet.repositories;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDRepository<E, K, V> {
	
    List<E> selectAll();

    void save(E e);

    E findById(String id);

    boolean update(E e) throws SQLException;

    boolean delete(String id) throws SQLException;

    List<E> search(String name);

}
