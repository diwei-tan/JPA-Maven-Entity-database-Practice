package application;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import model.Facility;
import model.Member;

public class BookingRegister {
	private HashMap<Facility, ArrayList<Booking>> bookings= new HashMap<Facility, ArrayList<Booking>>();
	
	public void addBooking(Member m, Facility f, LocalDateTime start, LocalDateTime end) throws BadBookingException {
		
		Booking b = new Booking(m, f, start, end);

		if(bookings.get(f)==null) {
			ArrayList<Booking> booklist = new ArrayList<Booking>();
			booklist.add(b);
			bookings.put(f, booklist);
		}
		else {
			for(Booking booking : bookings.get(f)) {
				if (booking.overlaps(b)) {
					throw new BadBookingException("booking overlaps with an exising book of facility "+f);
				}
			}
			bookings.get(f).add(b);
		}
	}
	public ArrayList<Booking> getBookings(Facility f, LocalDateTime rangeStart, LocalDateTime rangeEnd){
		ArrayList<Booking> BookingsWithinRange = new ArrayList<Booking>();
		for(Booking b : bookings.get(f)) {
			if(b.getStartDate().isAfter(rangeStart) && b.getEndDate().isBefore(rangeEnd)) {
				BookingsWithinRange.add(b);
			}
		}
		return BookingsWithinRange;
	}
	public void removeBooking(Booking booking) {
		bookings.get(booking.getFacility()).removeIf(booked -> booked==booking);
	}
}