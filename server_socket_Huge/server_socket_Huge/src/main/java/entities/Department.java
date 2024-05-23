package entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String location;
	private String name;
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private Set<Doctor> doctors;
	public Department() {
		super();
	}
	
	public Department(String id, String location, String name, Set<Doctor> doctors) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.doctors = doctors;
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
	
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, location, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", name=" + name + ", doctors=" + doctors + "]";
	}
	
	
}
