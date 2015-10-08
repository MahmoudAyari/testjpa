package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="TASK")
public class Task implements Serializable{

	
	private int id;
	private String name;
	private String description;
	private String priorite;
	private String state;
	private String duration;
	private Developer developer;
	private static final long serialVersionUID = 1L;

	
	
	public Task() {
		super();
	}   

	public Task(String name, String description, String priorite, String state, String duration, Developer developer) {
		super();
		this.name = name;
		this.description = description;
		this.priorite = priorite;
		this.state = state;
		this.duration = duration;
		this.developer = developer;
	}




	@ManyToOne
	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	
	@Id
    @GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getPriorite() {
		return this.priorite;
	}

	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
   
}
