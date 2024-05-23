package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Set<String> certification;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String specialty;
	@OneToMany(mappedBy = "doctor")
	private Set<Treatment> treatments;
	@ManyToOne
	private Department department;
	public Doctor() {
		super();
	}
	
	public Doctor(String id, Set<String> certifications, String firstName, String lastName, String email, String phone,
			String specialty, Set<Treatment> treatments, Department department) {
		super();
		this.id = id;
		this.certification = certifications;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.specialty = specialty;
		this.treatments = treatments;
		this.department = department;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<String> getCertifications() {
		return certification;
	}
	public void setCertifications(Set<String> certifications) {
		this.certification = certifications;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public int hashCode() {
		return Objects.hash(certification, email, firstName, id, lastName, phone, specialty);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(certification, other.certification) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone)
				&& Objects.equals(specialty, other.specialty);
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", certification=" + certification + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone + ", specialty=" + specialty + "]";
	}
	
	
}
