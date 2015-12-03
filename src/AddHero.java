import java.util.Scanner;

import javax.persistence.EntityManager;

import net.atos.entity.SuperHero;

public class AddHero {
	
	public String addHero(EntityManager entityManager, Scanner sc) {
		
		// This will be replaced by method that will interact with the User's input on website.
		SuperHero hero = new SuperHero();
		hero.setUid(1);
		System.out.println("Can you please enter the name of the Hero you would like to add: ");
		String heroName = sc.next();
		if(hero.equals(null) || hero.equals("")){
			System.err.println(error(entityManager));	
		}
		System.out.println("Hero name: " + heroName);
		System.out.println("Is your hero part of: ");
		System.out.println("1: Xmen");
		System.out.println("2: Avengers");
			
		hero.setName(heroName);
			
		int leagueOpt = sc.nextInt();
		if(leagueOpt == 1){
			hero.setLeague_id(1);
		}
		else if(leagueOpt == 2) {
			hero.setLeague_id(2);
		}
		else {
			System.err.println(error(entityManager));	
		}
			
		entityManager.persist(hero);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return ("You have successfully added: " + hero.getName());
	}
	
	private String error(EntityManager entityManager){
		
		entityManager.clear();
		entityManager.close();
		System.exit(0);
		return ("Incorrect input, please input either 1 or 2!");
		
	}
}
