package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.MemPK;
import model.Member;
import util.PersistenceManager;

public class MemberService {
	EntityManager em;
	
	public MemberService() {
		em = PersistenceManager.INSTANCE.getEntityManager();
	}
	public Member createMember(Member m){
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		return m;
	}
	public Member updateMember(String surname, String firstname, String secondname) {
		MemPK pk = new MemPK(surname, firstname);
		em.getTransaction().begin();
		Member m = em.find(Member.class, pk);
		m.setSecondname(secondname);
		em.persist(m);
		em.getTransaction().commit();
		return m;
	}
	public void removeMember(String surname, String firstname) {
		MemPK pk = new MemPK(surname, firstname);
		em.getTransaction().begin();
		Member m = em.find(Member.class, pk);
		em.remove(m);
		em.getTransaction().commit();
		System.out.println(m.toString() + " has been removed from database");
	}
	public Member listMember(String name) {
		String[] nameStr = name.split("[, ?.@]+");
		if(nameStr[0]!= null && nameStr[1] != null) {
			MemPK pk = new MemPK(nameStr[0], nameStr[1]);
			Member m = em.find(Member.class, pk);
			return m;
		}
		else {
			System.out.println("ERROR: Name does not have surname and firstname. Please try again.");
			return null;
		}
	}
	public List<Member> listAllMembers(){
		TypedQuery<Member> tq = em.createQuery("Select m From Member m", Member.class);
		return tq.getResultList();
	}
	
}
