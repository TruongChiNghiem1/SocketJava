package app;

import dao.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;

public class RunDatabase {
	public static void main(String[] args) {
		EntityManagerFactoryUtil entityManagerFactoryUtil = new EntityManagerFactoryUtil();
		EntityManager entityManager = entityManagerFactoryUtil.getEnManager();
		
		entityManagerFactoryUtil.closeEnManager();
		entityManagerFactoryUtil.closeEnManagerFactory();
	}
}