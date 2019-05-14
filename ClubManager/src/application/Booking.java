package application;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import model.Facility;
import model.Member;

@Entity
@Table(name="Bookings")
@IdClass(BookingPK.class)
public class Booking {
	@Column(name="MEMBER_SURNAME")
	private String memberSurname;
	@Column(name="MEMBER_FIRSTNAME")
	private String memberFirstname;
	@Id
	private String facilityName;
	private Facility facility;
	private Member member;
	@Id
	private LocalDateTime startDate;
	@Column(name="END_DATE")
	private LocalDateTime endDate;
	public Booking() {
		
	}
	public Booking(Member m, Facility f, LocalDateTime start, LocalDateTime end) throws BadBookingException{
		if(m==null)
			throw new BadBookingException("Member is required");
		if(f==null)
			throw new BadBookingException("Facility is required");
		if(start ==null || end==null)
			throw new BadBookingException("start and end dates are required");
		if(start.isAfter(end))
			throw new BadBookingException("start date cannot be after end date");
		member = m;
		memberSurname = m.getSurname();
		memberFirstname = m.getFirstname();
		facility = f;
		facilityName = f.getName();
		startDate = start;
		endDate = end;
	}
	public Member getMember() {
		return member;
	}
	public Facility getFacility() {
		return facility;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public boolean overlaps(Booking booking) {
		return(facility==booking.getFacility() && endDate.isAfter(booking.getStartDate()) && startDate.isBefore(booking.getEndDate()));
	}
	public void show() {
		System.out.println(this.toString());
	}
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-MMM-yyyy h:mm a");
		return facility.getName()+" is booked by "+member.toString()+" from "+startDate.format(dtf)+" to "+endDate.format(dtf);
	}
}
