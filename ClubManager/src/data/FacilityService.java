package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Facility;
import util.PersistenceManager;

public class FacilityService {
	EntityManager em;
	
	public FacilityService() {
		em = PersistenceManager.INSTANCE.getEntityManager();
	}
	public Facility createFacility(Facility f){
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		return f;
	}
	public Facility updateFacility(String name, String description) {
		em.getTransaction().begin();
		Facility f = em.find(Facility.class, name);
		f.setDescription(description);
		em.persist(f);
		em.getTransaction().commit();
		return f;
	}
	public void removeFacility(String name) {
		em.getTransaction().begin();
		Facility f = em.find(Facility.class, name);
		em.remove(f);
		em.getTransaction().commit();
		System.out.println(f.toString() + " has been removed from database");
	}
	public Facility listFacility(String name) {
		Facility f = em.find(Facility.class, name);
		return f;
	}
	public List<Facility> listAllMembers(){
		TypedQuery<Facility> tq = em.createQuery("Select f From Facility f", Facility.class);
		return tq.getResultList();
	}
	
}
