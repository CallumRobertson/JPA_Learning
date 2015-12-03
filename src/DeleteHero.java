import java.util.Scanner;

import javax.persistence.EntityManager;

import net.atos.entity.SuperHero;

public class DeleteHero {
	
	public String deleteHero(EntityManager entityManager, Scanner sc){
		return delete(entityManager, sc);
	}
	
	private String delete(EntityManager entityManager, Scanner sc){
		System.out.println("Please enter the ID of the Hero you wish to delete: ");
		int id = sc.nextInt();
		
		SuperHero superHero = entityManager.find(SuperHero.class, id);	
		entityManager.remove(superHero);
		entityManager.getTransaction().commit();	
		return ("Successfully Deleted " + superHero.getName());
	}
}
