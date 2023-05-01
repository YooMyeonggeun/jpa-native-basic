package hellojpa;

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
//			member.setTeamId(team.getId());
			member.setTeam(team);
			em.persist(member);
			
			Member findMember = em.find(Member.class, member.getId());
//			Long teamId = findMember.getTeamId();
//			
//			Team findTeam = em.find(Team.class, teamId);
			
			Team findTeam = findMember.getTeam();
			System.out.println("아이디 : "+findTeam.getId());
			System.out.println("이름 : "+findTeam.getName());
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			emf.close();
		}
	}
}
