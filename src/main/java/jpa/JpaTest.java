package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.PathParam;

import dao.DeveloperDao;
import domain.Developer;
import domain.MobileDeveloper;
import domain.Sprint;
import domain.Task;
import domain.Team;
import service.DeveloperService;

public class JpaTest {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		DeveloperDao developerDao = new DeveloperDao();
		//developerDao.insert(new Developer("nn","ff",null));
		Developer dev =developerDao. findById(16);
		developerDao.delete(dev.getId());
		System.out.println("deleted");
		
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("dev");
//		EntityManager manager = factory.createEntityManager();
//
//		EntityTransaction tx = manager.getTransaction();
//		tx.begin();
//		try {
//			
//         Team t= new Team("team5");
//         
//         Developer d= new Developer("mahmoud", "ayari", null);
//         manager.persist(t);
//         manager.persist(d);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		tx.commit();
//		manager.close();
//		factory.close();
	}


	
	
}
