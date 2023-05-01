package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;
import entity.Team;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction(); // jpa에 모든 활동은 트랜잭션안에서 실행된다
		tx.begin();
		try {
			Team team = new Team();
			team.setName("teamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("hello");
//			member.setTeam(team);
			em.persist(member);
//			team.getMembers().add(member);
			member.setTeam(team);
			
			em.flush();
			em.clear();
			
//			Member findMember = em.find(Member.class, member.getId());
//			Team findTeam = findMember.getTeam();
//			findTeam.getName();
//			
//			List<Member> members = findTeam.getMembers();
//			for(Member member1 : members) {
//				System.out.println("member1 = "+ member1);
//			}
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			emf.close();
		}
	}
}
