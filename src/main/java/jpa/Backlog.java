package jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="BACKLOG")
public class Backlog implements Serializable{
	@Id
	private int id;
	
	
	
	
}
