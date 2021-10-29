package br.com.leandro.logisticsbackend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudMethods<T> {

    Page<T> getAll(Pageable pageable);
    T getById(int id);
    T create(T entity);
    T update(int id, T entity);
    void delete(int id);
}
