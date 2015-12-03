import java.util.Scanner;

import javax.persistence.*;

public class Main {
	
	public static void main(String[] args) 
	{	// Initialises EntityManagerFactory, Scanner and EntityManager to begin my connection.
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		// Creates an object of Main class so I can call non-static methods.
		Main m = new Main();
		// Creates new object of function classes.
		AddHero add = new AddHero();
		UpdateHero up = new UpdateHero();
		DeleteHero del = new DeleteHero();
		// Calls non-static method to the Main to get initial options from user.
		m.options(sc, entityManager, add, up, del);
	}

	private void options(Scanner sc, EntityManager entityManager, 
		AddHero add, UpdateHero up, DeleteHero del) 
	{
		System.out.println("Hi please select an option: ");
		System.out.println("1. Add a Hero!");
		System.out.println("2. Edit a Hero!");
		System.out.println("3. Delete a Hero!");
		int opt = sc.nextInt();
		if(opt == 1){
			// Creates a String and puts the returned value from the method into rs.
			String rs = add.addHero(entityManager, sc);
			System.out.println(rs);
		}
		if(opt == 2){
			// Creates a String and puts the returned value from the method into rs.
			String rs = up.updateHero(entityManager, sc);
			System.out.println(rs);
		}
		if(opt == 3){
			// Creates a String and puts the returned value from the method into rs.
			String rs = del.deleteHero(entityManager, sc);
			System.out.println(rs);
		}
	}
}
