package com.devincubator.project.hibernate.repository.abstracts;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CrudRepository<T> {

    SessionFactory getBeanToBeAutowired();

    // create
    @SuppressWarnings("unchecked")
    default T add(T entity){
        return (T) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }

    // read
    @SuppressWarnings("unchecked")
    default T getById(Class<T> entityClass, long id){
        return (T)getBeanToBeAutowired().getCurrentSession().find(entityClass, id);
    }

    // update
    @SuppressWarnings("unchecked")
    default T update(T entity){
        return (T) getBeanToBeAutowired().getCurrentSession().merge(entity);
    }

    // delete
    default void delete(T entity){
        getBeanToBeAutowired().getCurrentSession().remove(entity);
    }

    @SuppressWarnings("unchecked")
    default List<T> getAll(Class<T> t){
        return (List<T>)getBeanToBeAutowired()
                .getCurrentSession()
                .createQuery("FROM " + t.getSimpleName())
                .list();
    }

    default T getByName(Class<T> entityClass, String name){
        return (T)getBeanToBeAutowired().getCurrentSession().find(entityClass, name);
    }

}
