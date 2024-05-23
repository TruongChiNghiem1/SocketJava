package dao;

import java.util.List;

import entities.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class Doctor_DAO {
	private EntityManager entityManager;

	public Doctor_DAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	public List<Doctor> findDoctorBySpeciality(String specialty) {
//		Query q1 = entityManager.createNativeQuery("select d from Doctor d where d.specialty = ?").setParameter(1, specialty);
		Query q = entityManager.createQuery("select d from Doctor d where d.specialty = :specialty",Doctor.class);
		q.setParameter("specialty",specialty);
		return q.getResultList();
		
	}
}
