package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Task;

public class TaskDao implements DaoInterface<Task, Serializable> {

	private static final String SELECT_QUERY = "select t from Task t";

	private EntityManager entityManager;

	public TaskDao() {
		super();
		this.entityManager = Manager.getManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Task entity) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(entity);
			tx.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Task findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Task.class, id);
	}

	public void delete(Task entity) {
		entity = this.entityManager.merge(entity);
		this.entityManager.remove(entity);
	}

	public List<Task> findAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Task> Tasks = (List<Task>) query.getResultList();
		return Tasks;
	}

	public void deleteAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Task> Tasks = (List<Task>) query.getResultList();
		for (Task d : Tasks) {
			this.entityManager.remove(d);
		}
		System.out.println("deleted");
	}

	public void update(Task entity) {
		entityManager.merge(entity);

	}

}
