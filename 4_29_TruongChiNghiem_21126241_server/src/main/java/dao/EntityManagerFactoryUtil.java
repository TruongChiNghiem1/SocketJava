package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("nghiemsocket4");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void closeEntityManager() {
		entityManager.close();
	}
	
	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
