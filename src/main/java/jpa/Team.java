package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;
import java.util.*;

import ​javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="TEAM")
public class Team implements Serializable {

	@Id
	private int id;
	private ​​List<Developer> developers​=new ArrayList<Developer>();
	
	​@OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)​
	public List<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	} 
	
	
}
