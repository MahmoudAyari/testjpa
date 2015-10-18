package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="SPRINT")
public class Sprint implements Serializable {

	
	
	private int id;
	
	private String name;
	
	private List<Task> tasks = new ArrayList<Task>();

	
	public Sprint() {
		super();
	}
	
	
	public Sprint(String name) {
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
	
	@OneToMany(mappedBy = "sprint", cascade = CascadeType.PERSIST)
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
	
}
