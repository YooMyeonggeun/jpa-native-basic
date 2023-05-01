package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
	
	@Id @GeneratedValue
	private Long id; 
	@Column(name="username")
	private String name;
	
	@Column(name="TEAM_ID")
	private Long teamId;
	
//	@Enumerated(EnumType.STRING)
//	private MemberType memberType;

}
