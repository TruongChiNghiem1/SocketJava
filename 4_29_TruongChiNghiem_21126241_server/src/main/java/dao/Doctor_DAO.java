package dao;

import java.util.List;

import entities.Doctor;
import jakarta.persistence.EntityManager;

public class Doctor_DAO {
	private EntityManager entityManager;

	public Doctor_DAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public List<Object[]> findDoctorDepartment() {
		try {
			return entityManager.createQuery("SELECT de.name AS department, COUNT(d.id) AS count\r\n"
					+ "FROM Doctor d\r\n"
					+ "JOIN department de\r\n"
					+ "GROUP BY de.name", Object[].class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
