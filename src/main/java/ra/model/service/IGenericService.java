package ra.model.service;

import ra.model.dto.BlogDto;
import ra.model.entity.Blog;

import java.util.List;

public interface IGenericService<T, E> {
    List<T> findAll();

    T findById(E e);


    void save(T t);

    void delete(E e);

}
