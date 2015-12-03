package net.atos.entity;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "super_hero")
public class SuperHero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ_SCORE")
	@SequenceGenerator(name="SEQ_SCORE", sequenceName="PK_scores")
	@Column(name = "uid", nullable = false) 
	Integer uid;
	@NotNull
	String name;
	@NotNull
	Integer league_id;
	
	public SuperHero(int uid, String name, int league_id){
		super();
		this.uid = uid;
		this.name = name;
		this.league_id = league_id;
	}
	
	public SuperHero(){
		super();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLeague_id() {
		return league_id;
	}

	public void setLeague_id(int league_id) {
		this.league_id = league_id;
	}
	
	
}
