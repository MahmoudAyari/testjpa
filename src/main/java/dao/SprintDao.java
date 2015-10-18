package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Sprint;

public class SprintDao implements DaoInterface<Sprint, Serializable> {

	private static final String SELECT_QUERY = "select s from Sprint s";

	private EntityManager entityManager;

	public SprintDao() {
		super();
		this.entityManager = Manager.getManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Sprint entity) {
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

	public Sprint findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Sprint.class, id);
	}

	public void delete(Sprint entity) {
		entity = this.entityManager.merge(entity);
		this.entityManager.remove(entity);
	}

	public List<Sprint> findAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		@SuppressWarnings("unchecked")
		List<Sprint> Sprints = (List<Sprint>) query.getResultList();
		return Sprints;
	}

	public void deleteAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Sprint> Sprints = (List<Sprint>) query.getResultList();
		for (Sprint d : Sprints) {
			this.entityManager.remove(d);
		}
		
	}

	public void update(Sprint entity) {
		entityManager.merge(entity);

	}

}
