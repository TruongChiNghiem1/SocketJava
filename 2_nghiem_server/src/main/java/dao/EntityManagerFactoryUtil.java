package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManager entiryManager;
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("nghiem_server");
		entiryManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entiryManager;
	}
	
	public void closeEntityManager() {
		entiryManager.close();
	}
	
	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
