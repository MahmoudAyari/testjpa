package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
	
			Team team = new Team("team1");
			manager.persist(team);
			
			Developer developer = new Developer("a","a", team);
			manager.persist(developer);
			
			Sprint sprint = new Sprint("sprint1");
			manager.persist(sprint);
			
			Task t = new Task("t","t","t","t","t",developer,sprint);
			manager.persist(t);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		factory.close();
	}


	
	
}
