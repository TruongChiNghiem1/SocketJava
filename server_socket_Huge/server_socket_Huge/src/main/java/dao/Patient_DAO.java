package dao;

import entities.Patient;
import jakarta.persistence.EntityManager;

public class Patient_DAO {
	private EntityManager entityManager;

	
	public Patient_DAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public Patient addPatient(Patient p) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return null;
		}
	}
	
	public boolean deletePatient(String ma) {
		try {
			entityManager.getTransaction().begin();
			Patient p = entityManager.find(Patient.class, ma);
			entityManager.remove(p);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			return false;
		}
	}
}
