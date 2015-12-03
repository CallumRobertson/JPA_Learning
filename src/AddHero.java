import java.util.Scanner;

import javax.persistence.EntityManager;

import net.atos.entity.SuperHero;

public class AddHero {
	
	public String addHero(EntityManager entityManager, Scanner sc){
		return add(entityManager, sc);
	}
	
	public String add(EntityManager entityManager, Scanner sc) {
		// This will be replaced by method that will interact with the User's input on website.
		//Creates an object of my Entity class SuperHero
		SuperHero hero = new SuperHero();
		// Sets the Uid in the hero class.
		hero.setUid(1);
		System.out.println("Can you please enter the name of the Hero you would like to add: ");
		String heroName = sc.next();
		// If the user inputs a nothing this will be printed.
		if(hero.equals(null) || hero.equals("")){
			String er = error(entityManager);
			System.out.println(er);	
		}
		System.out.println("Hero name: " + heroName);
		System.out.println("Is your hero part of: ");
		System.out.println("1: Xmen");
		System.out.println("2: Avengers");
		// This takes the input from User and then inputs into DB.	
		hero.setName(heroName);
		// Sets the league_id based on user input.
		int leagueOpt = sc.nextInt();
		if(leagueOpt == 1){
			hero.setLeague_id(1);
		}
		else if(leagueOpt == 2) {
			hero.setLeague_id(2);
		}
		// If the user inputs a nothing this will be printed.
		else {
			String er = error(entityManager);
			System.out.println(er);	
		}
		// Places the object hero into the DB.	
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
