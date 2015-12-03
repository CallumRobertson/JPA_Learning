import java.util.Scanner;

import javax.persistence.*;
import net.atos.entity.SuperHero;

public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		AddHero add = new AddHero();
		UpdateHero up = new UpdateHero();
		DeleteHero del = new DeleteHero();
		System.out.println("Hi please select an option: ");
		System.out.println("1. Add a Hero!");
		System.out.println("2. Edit a Hero!");
		System.out.println("3. Delete a Hero!");
		int opt = sc.nextInt();
		
		if(opt == 1){
			String rs = add.addHero(entityManager, sc);
			System.out.println(rs);
		}
		
		if(opt == 2){
			String rs = up.updateHero(entityManager, sc);
			System.out.println(rs);
		}
		
		if(opt == 3){
			String rs = del.deleteHero(entityManager, sc);
			System.out.println(rs);
		}
		

	}

}
