package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {

	static EntityManager manager;

	public Manager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		manager = factory.createEntityManager();

	}

	public static EntityManager getManager() {
		if (manager == null) {
			Manager t = new Manager();
			return t.getManager();
		} else
			return manager;
	}
}
