package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Developer;

public class DeveloperDao implements DaoInterface<Developer, Serializable> {

	private static final String SELECT_QUERY = "select d from Developer d";

	private EntityManager entityManager;

	public DeveloperDao() {
		super();
		this.entityManager = Manager.getManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Developer entity) {
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

	public Developer findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Developer.class, id);
	}

	public void delete(int id) {
		
		Developer dev = new Developer();
		dev = entityManager.find(Developer.class, id);
		dev.getName();
		System.out.println(dev.getName());
		entityManager.remove(entityManager.find(Developer.class, id));
		
	}

	public List<Developer> findAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Developer> developers = (List<Developer>) query.getResultList();
		return developers;
	}

	public void deleteAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Developer> developers = (List<Developer>) query.getResultList();
		for (Developer d : developers) {
			this.entityManager.remove(d);
		}
	}

	public void update(Developer entity) {
		entityManager.merge(entity);

	}

}
