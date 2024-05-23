package dao;

import java.util.List;

import entities.Doctor;
import entities.Patient;
import jakarta.persistence.EntityManager;

public class Patient_DAO {
	private EntityManager entityManager;

	public Patient_DAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public Patient add(Patient p) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delete(String idDelete) {
		try {
			entityManager.getTransaction().begin();
			Patient p = entityManager.find(Patient.class, idDelete);
			entityManager.remove(p);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Doctor> findListDoctor(String specialty){
		try {
			return entityManager.createQuery("SELECT d.id, d.email, d.firstName, d.lastName, d.phone, d.specialty "
					+ "FROM Doctor d WHERE specialty = :specialty", Doctor.class)
					.setParameter("specialty", specialty)
					.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
