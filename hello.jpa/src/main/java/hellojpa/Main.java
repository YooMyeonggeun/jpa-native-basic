package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction(); // jpa에 모든 활동은 트랜잭션안에서 실행된다
		tx.begin();
		try {
			Member member = new Member();
			member.setId(100L);
			member.setName("hello");
			member.setAge(10);
			em.persist(member);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			emf.close();
		}
		System.out.println("hello");

	}
}
