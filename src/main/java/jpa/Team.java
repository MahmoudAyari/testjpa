package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.util.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="TEAM")
public class Team implements Serializable {

	
	
	private int id;
	
	private String name;

	private List<Developer> developers = new ArrayList<Developer>();
	
	
	
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team( String name) {
		super();
		this.name = name;
	}

	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}
	
	
	
	
	
	
}
