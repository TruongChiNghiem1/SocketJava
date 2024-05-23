package entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5951317614463105953L;
	
	@Id
	private String id;
	
	private String location;
	private String name;
	
	@OneToMany(mappedBy = "department")
	private List<Doctor> doctor;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String id, String location, String name, List<Doctor> doctor) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.doctor = doctor;
	}

	public Department(String id, String location, String name) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", name=" + name + ", doctor=" + doctor + "]";
	}
	
	
}
