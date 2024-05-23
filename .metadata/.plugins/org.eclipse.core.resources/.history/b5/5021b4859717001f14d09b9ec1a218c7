package app;

import dao.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;

public class RunDatabase {
	public static void main(String[] args) {
		EntityManagerFactoryUtil en = new EntityManagerFactoryUtil();
		EntityManager entityManager = en.getEntityManager();
		
		en.closeEntityManager();
		en.closeEntityManagerFactory();
	}
}
