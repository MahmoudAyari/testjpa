package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="SPRINT")
public class Sprint implements Serializable {

	
	@Id
	private int id;
	private String name;
	
}
