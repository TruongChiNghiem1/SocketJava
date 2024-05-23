package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Treatment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String description;
	private Date endDate;
	private Date startDate;
	
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Doctor doctor;
	
	
	
	public Treatment(int id, String description, Date endDate, Date startDate, Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
		this.patient = patient;
		this.doctor = doctor;
	}


	public Treatment() {
		super();
	}


	@Override
	public String toString() {
		return "Treatment [id=" + id + ", description=" + description + ", endDate=" + endDate + ", startDate="
				+ startDate + ", patient=" + patient + ", doctor=" + doctor + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, endDate, id, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treatment other = (Treatment) obj;
		return Objects.equals(description, other.description) && Objects.equals(endDate, other.endDate)
				&& id == other.id && Objects.equals(startDate, other.startDate);
	}
	
	
}
