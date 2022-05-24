package com.egs.egs_employee.dao;

import java.util.List;

public interface DAO<T> {

    T get(long id);

    List<T> getAll();

    T save(T t);

    void update(T t);

    int delete(T t);

    T getByUsername(String username);
}
