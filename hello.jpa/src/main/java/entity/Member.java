package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Member {
	
	@Id @GeneratedValue
	private Long id; 
	@Column(name="username")
	private String name;
	
//	@Column(name="TEAM_ID")
//	private Long teamId;
	
	@ManyToOne(fetch = FetchType.LAZY) // 지연로딩
	@JoinColumn(name = "team_id")
	private Team team;
	

}
