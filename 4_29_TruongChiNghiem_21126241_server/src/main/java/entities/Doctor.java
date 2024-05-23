package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6067501781791775003L;
	
	@Id
	private String id;
	
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private String specialty;
	
	@OneToMany(mappedBy = "doctor")
	private List<Treatment> treatment;
	
	@ManyToOne
	private Department department;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(String id, String email, String firstName, String lastName, String phone, String specialty) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.specialty = specialty;

	}

	public Doctor(String id, String email, String firstName, String lastName, String phone, String specialty,
			List<Treatment> treatment, Department department) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.specialty = specialty;
		this.treatment = treatment;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public List<Treatment> getTreatment() {
		return treatment;
	}

	public void setTreatment(List<Treatment> treatment) {
		this.treatment = treatment;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", specialty=" + specialty + ", treatment=" + treatment + ", department="
				+ department + "]";
	}
	
	
	
}
