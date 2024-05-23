package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Patient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5193478249838086857L;
	
	@Id
	private String id;
	private String address;
	private int age;
	private String firstName;
	private String gender;
	private String lastName;
	private String phone;
	
	@OneToMany(mappedBy = "patient")
	private List<Treatment> treatment;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(String id, String address, int age, String firstName, String gender, String lastName, String phone) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.phone = phone;
	}

	public Patient(String id, String address, int age, String firstName, String gender, String lastName, String phone,
			List<Treatment> treatment) {
		super();
		this.id = id;
		this.address = address;
		this.age = age;
		this.firstName = firstName;
		this.gender = gender;
		this.lastName = lastName;
		this.phone = phone;
		this.treatment = treatment;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return "Patient [id=" + id + ", address=" + address + ", age=" + age + ", firstName=" + firstName + ", gender="
				+ gender + ", lastName=" + lastName + ", phone=" + phone + ", treatment=" + treatment + "]";
	}
	
	
}
