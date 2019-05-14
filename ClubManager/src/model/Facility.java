package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Facilities")
public class Facility {
	@Id
	@Column(name="FACILITY_NAME")
	private String name;
	@Column(name="DESCRIPTION")
	private String description;
	
	public Facility() {
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Facility(String name, String desc) {
		this.name=name;
		description=desc;
	}
	public Facility(String name) {
		this(name, null);
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public void show() {
		System.out.println(this.toString());
	}
	@Override
	public String toString() {
		if(description==null) {
			return name;
		} else {
			return name + ": " + description;
		}
	}
}
