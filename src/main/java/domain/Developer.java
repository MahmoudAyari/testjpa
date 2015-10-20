package domain;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Entity implementation class for Entity: Developer
 *
 */
@Entity
@Table(name = "DEVELOPER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("D")
public class Developer implements Serializable {

	private int id;
	private String name;
	private String surname;
	@JsonIgnore
	private Team team;
	@JsonIgnore
	private List<Task> tasks = new ArrayList<Task>();

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public Developer() {

	}

	public Developer(String name, String surname, Team team) {
		super();
		this.name = name;
		this.surname = surname;
		this.team = team;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@OneToMany(mappedBy = "developer", cascade = CascadeType.PERSIST)
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToOne
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
