package application;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import model.Facility;
import model.Member;

public class Club {
	private HashMap<String, Facility> facilities = new HashMap<String, Facility>();
	private static int membershipNum =1;
	private ArrayList<Member> clubMembers = new ArrayList<Member>();
	private BookingRegister bookingRegister = new BookingRegister();
	
	//Managing modules for members
	public void addMember(String surname, String firstname, String secondName) {
		Member m = new Member(membershipNum, surname, firstname, secondName);
		clubMembers.add(m);
		membershipNum++;
	}
	public ArrayList<Member> getClubMembers() {
		return clubMembers;
	}
	public void showMembers() {
		for(Member member : clubMembers) {
			member.show();
		}
	}
	public void removeMember(int num) throws Exception{
		boolean removed = clubMembers.removeIf(member -> (member.getMemberNo() == num));
		if(!removed) {
			throw new Exception("Member no." + num + " could not be found");
		}
	}
	public Member getMemberByMemberNum(int num) {
		Member member=null;
		for (Member m : clubMembers) {
			if(m.getMemberNo()==num) {
				member = m;
				break;
			}
		}
		return member;
	}
	
	//Facilities management
	public Facility getFacility(String name) {
		return facilities.get(name);
	}
	public HashMap<String, Facility> getFacilities(){
		return facilities;
	}
	public void addFacility(String name, String description) {
		Facility f = new Facility(name, description);
		facilities.put(f.getName(), f);
		System.out.println(f.getName() + " Has been added to facilities.");
	}
	public void removeFacility(String name) {
		facilities.remove(name);
	}
	public void showFacilities() {
		for(Facility f : facilities.values()) {
			f.show();
		}
	}
	
	//show method to show all members and facilities
	public void show() {
		System.out.println("CLUB INFO:");
		System.out.println();
		System.out.println("MEMBERS");
		System.out.println("-------");
		for(Member m : clubMembers) {
			m.show();
		}
		System.out.println();
		System.out.println("FACILITIES");
		System.out.println("----------");
		for(Facility f : facilities.values()) {
			f.show();
		}
	}
	
	//methods for booking register management
	public void addBooking(int memberNum, String facilityName, LocalDateTime start, LocalDateTime end) throws BadBookingException{
		Member member = this.getMemberByMemberNum(memberNum);
		Facility facility = this.getFacility(facilityName);
		bookingRegister.addBooking(member, facility, start, end);
	}
	public ArrayList<Booking> getBookings(String facilityName, LocalDateTime rangeStart, LocalDateTime rangeEnd){
		ArrayList<Booking> bookingsWithinRange = bookingRegister.getBookings(this.getFacility(facilityName), rangeStart, rangeEnd);
		return bookingsWithinRange;
	}
	public void showBookings(String facilityName, LocalDateTime rangeStart, LocalDateTime rangeEnd) {
		ArrayList<Booking> bookingsWithinRange = this.getBookings(facilityName, rangeStart, rangeEnd);
		System.out.println("BOOKINGS WITHIN RANGE");
		System.out.println("---------------------");
		for(Booking b : bookingsWithinRange) {
			b.show();
		}
	}
}
