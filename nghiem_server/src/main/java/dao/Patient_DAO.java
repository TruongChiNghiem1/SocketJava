package dao;

import entities.Patient;
import jakarta.persistence.EntityManager;

public class Patient_DAO {
	private EntityManager entityManager;

	public Patient_DAO(EntityManager entityManager) {
		super();
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;
	}
	
	public Patient add(Patient p) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}