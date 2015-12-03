import java.util.Scanner;

import javax.persistence.EntityManager;

import net.atos.entity.SuperHero;

public class UpdateHero {

	public String updateHero(EntityManager entityManager, Scanner sc){
		 
		return hero(entityManager, sc);
		
	}
	
	private String hero(EntityManager entityManager, Scanner sc) {
		System.out.println("Please enter the ID of the Hero you wish to update.");
		int id = sc.nextInt();
		SuperHero superHero = entityManager.find(SuperHero.class, id);
		
		System.out.println("Input new Name for: " + superHero.getName());
		String name = sc.next();
		superHero.setName(name);
		entityManager.getTransaction().commit();
		System.out.println("New name is: " + superHero.getName());
		
		return ( "Super Hero's Name: "+ superHero.getName() + " UID: " + superHero.getUid() + " League Number: "
		+ superHero.getLeague_id());
	}
}
