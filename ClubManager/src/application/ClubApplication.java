package application;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import data.FacilityService;
import data.MemberService;
import model.Facility;
import model.Member;

public class ClubApplication {

	public static void main(String[]args) {
		//test
		MemberService ms = new MemberService();
		
		//Find Tan Di Wei
		Member m = ms.listMember("Tan Di Wei");
		System.out.println(m.toString());
		
		//List all members
		List<Member> members = ms.listAllMembers();
		if(members.isEmpty()) {
			System.out.println("ERROR: NO MEMBERS FOUND IN SYSTEM. SYSTEM WILL NOW QUIT");
			System.exit(1);
		}
		else {
			System.out.println("MEMBERS");
			System.out.println("-------");
			Iterator<Member> iterator = members.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next().toString());
			}
		}
		System.out.println();
		//Facilities tests
		FacilityService fs = new FacilityService();
		Facility f = fs.listFacility("MPH");
		System.out.println(f.toString());
		
		//List all facilities
		List<Facility> facilities = fs.listAllMembers();
		if(facilities.isEmpty()) {
			System.out.println("ERROR: NO FACILITIES IN SYSTEM. SYSTEM WILL NOW QUIT");
			System.exit(1);
		}
		else {
			Iterator<Facility> iteratorf = facilities.iterator();
			System.out.println("FACILITIES");
			System.out.println("----------");
			while(iteratorf.hasNext()){
				System.out.println(iteratorf.next().toString());
			}
		}
		
		
		
	}


}
