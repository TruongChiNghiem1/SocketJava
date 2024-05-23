package app;

import dao.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;

public class RunDatabase {
	public static void main(String[] args) {
		EntityManagerFactoryUtil managerFactoryUtil = new EntityManagerFactoryUtil();
		EntityManager entityManager = managerFactoryUtil.getEnManager();
		
		managerFactoryUtil.closeEnManager();
		managerFactoryUtil.closeEnManagerFactory();
	}
}
