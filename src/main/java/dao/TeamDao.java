package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Team;

public class TeamDao implements DaoInterface<Team, Serializable> {

	private static final String SELECT_QUERY = "select t from Team t";

	private EntityManager entityManager;

	public TeamDao() {
		super();
		this.entityManager = Manager.getManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Team entity) {
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

	public Team findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Team.class, id);
	}

//	public void delete(Team entity) {
//		entity = this.entityManager.merge(entity);
//		this.entityManager.remove(entity);
//	}

	public List<Team> findAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Team> Teams = (List<Team>) query.getResultList();
		return Teams;
	}

	public void deleteAll() {
		Query query = entityManager.createQuery(SELECT_QUERY);
		List<Team> Teams = (List<Team>) query.getResultList();
		for (Team d : Teams) {
			this.entityManager.remove(d);
		}
		System.out.println("deleted");
	}

	public void update(Team entity) {
		entityManager.merge(entity);

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
