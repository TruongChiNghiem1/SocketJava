package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6067501781791775003L;
	
	@Id
	private String id;
	
	private Set<String> certifications;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private String specialty;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department")
	private Department department;
	
	@OneToMany(mappedBy = "doctor")
	private List<Treatment> treatment;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String id, Set<String> certifications, String email, String firstName, String lastName, String phone,
			String specialty, Department department, List<Treatment> treatment) {
		super();
		this.id = id;
		this.certifications = certifications;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.specialty = specialty;
		this.department = department;
		this.treatment = treatment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<String> certifications) {
		this.certifications = certifications;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Treatment> getTreatment() {
		return treatment;
	}

	public void setTreatment(List<Treatment> treatment) {
		this.treatment = treatment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", certifications=" + certifications + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", phone=" + phone + ", specialty=" + specialty
				+ ", department=" + department + ", treatment=" + treatment + "]";
	}
	
	
	
}
