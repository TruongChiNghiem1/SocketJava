package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String address;
	private int age;
	private String firstName;
	private String lastName;
	private String gender;
	private String phone;
	
	@OneToMany(mappedBy = "patient")
	private Set<Treatment> treatments;
	
	public Patient(String id, String address, int age, String firstName, String lastName, String gender, String phone) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phone = phone;
	}
	public Patient() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Set<Treatment> getTreatments() {
		return treatments;
	}
	public void setTreatments(Set<Treatment> treatments) {
		this.treatments = treatments;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, age, firstName, gender, id, lastName, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phone, other.phone);
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", address=" + address + ", age=" + age + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", phone=" + phone + ", treatments=" + treatments
				+ "]";
	}
	
	
}
