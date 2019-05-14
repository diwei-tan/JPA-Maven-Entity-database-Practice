package model;

import java.io.Serializable;

import javax.persistence.Column;

public class MemPK implements Serializable{
	@Column(name="SURNAME")
	protected String surname;
	@Column(name="FIRST_NAME")
	protected String firstname;
	
	public MemPK() {
		
	}

	public MemPK(String surname, String firstname) {
		super();
		this.surname = surname;
		this.firstname = firstname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemPK other = (MemPK) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
}

