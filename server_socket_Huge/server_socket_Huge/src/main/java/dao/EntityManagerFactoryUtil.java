package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("nghiemsocket3");
		entityManager = entityManagerFactory.createEntityManager();
		
		
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void closeEnManager() {
		entityManager.clear();
	}
	
	public void closeEnManagerFactory() {
		entityManagerFactory.close();
	}
	
}