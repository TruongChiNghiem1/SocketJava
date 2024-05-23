package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "treatment")
public class Treatment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -230094093673695763L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	private LocalDate endDate;
	private LocalDate startDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor")
	private Doctor doctor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient")
	private Patient patient;

	public Treatment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Treatment(Long id, String description, LocalDate endDate, LocalDate startDate, Doctor doctor,
			Patient patient) {
		super();
		this.id = id;
		this.description = description;
		this.endDate = endDate;
		this.startDate = startDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Treatment [id=" + id + ", description=" + description + ", endDate=" + endDate + ", startDate="
				+ startDate + ", doctor=" + doctor + ", patient=" + patient + "]";
	}

	
	
}
