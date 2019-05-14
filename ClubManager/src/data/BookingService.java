package data;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import application.Booking;
import application.BookingPK;
import util.PersistenceManager;

public class BookingService {
	EntityManager em;
	public BookingService() {
		em = PersistenceManager.INSTANCE.getEntityManager();
	}
	public Booking createBooking(Booking b){
		List<Booking> booked = listAllBookings();
		boolean overlap = false;
		Iterator<Booking> iterator = booked.iterator();
		while(iterator.hasNext()) {
			Booking next = iterator.next();
			if(next.overlaps(b)) {
				overlap=true;
				break;
			}
		}
		if(!overlap) {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			return b;
		}
		else {
			System.out.println("ERROR: BOOKING OVERLAPS. WILL NOT ADD TO DATABASE");
			return null;
		}

	}
	public void removeBooking(String facilityName, LocalDateTime startDate) {
		BookingPK bpk = new BookingPK(facilityName, startDate);
		em.getTransaction().begin();
		Booking b = em.find(Booking.class, bpk);
		em.remove(b);
		em.getTransaction().commit();
		System.out.println(b.toString() + " has been removed from database");
	}
	public Booking listBooking(String facilityName, LocalDateTime startDate) {
		BookingPK bpk = new BookingPK(facilityName, startDate);
		Booking b = em.find(Booking.class, bpk);
		return b;
	}
	public List<Booking> listAllBookings(){
		TypedQuery<Booking> tq = em.createQuery("Select b From Booking f", Booking.class);
		return tq.getResultList();
	}
}
