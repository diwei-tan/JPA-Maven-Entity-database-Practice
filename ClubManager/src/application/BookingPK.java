package application;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

public class BookingPK implements Serializable{
	@Column(name="FACILITIES_NAME")
	protected String facilityName;
	@Column(name="START_DATE")
	protected LocalDateTime startDate;
	
	public BookingPK() {
		
	}
	public BookingPK(String facilityName, LocalDateTime time) {
		this.facilityName = facilityName;
		startDate = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		BookingPK other = (BookingPK) obj;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
}
