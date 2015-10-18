package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface DaoInterface<T, Id extends Serializable> {

	public EntityManager getEntityManager();

	public void setEntityManager(EntityManager entityManager);

	public void insert(T entity);

	public void update(T entity);

	public T findById(int id);

	public void delete(T entity);

	public List<T> findAll();

	public void deleteAll();

}