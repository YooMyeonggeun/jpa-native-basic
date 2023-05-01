package hellojpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		emf.close();
		System.out.println("hello");
		
	}
}
