package service;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import dao.DeveloperDao;
import domain.Developer;

@Path("/developer")
public class DeveloperService {

	private DeveloperDao developerDao;

	public DeveloperService(DeveloperDao developerDao) {
		super();
		this.developerDao = developerDao;
	}

	public DeveloperDao getDeveloperDao() {
		return developerDao;
	}

	public void setDeveloperDao(DeveloperDao developerDao) {
		this.developerDao = developerDao;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public Developer insertContact(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("surname") String surname) {

		Developer developer = new Developer();
		developer.setId(id);
		developer.setName(name);
		developer.setSurname(surname);
		getDeveloperDao().insert(developer);
		return developer;

	}

	@GET
	@Path("/{developerId}")
	@Produces(MediaType.APPLICATION_XML)
	public Developer getContact(@PathParam("developerId") int id) {
		Developer developer = developerDao.findById(id);
		return developer;
	}

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Developer> findAll() {
		return getDeveloperDao().findAll();

	}

	@PUT
	@Path("/{developerId}")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Developer updateContact(@PathParam("developerId") int id, @FormParam("name") String name,
			@FormParam("surname") String surname, @FormParam("teamId") int teamId) {
		Developer developer = new Developer();
		developer.setId(id);
		developer.setName(name);
		developer.setSurname(surname);
		getDeveloperDao().update(developer);
		return developer;
	}

	@DELETE
	@Path("/{developerId}")
	public void deleteContact(@PathParam("developerId") int id) {
		Developer developer = new Developer();
		developer.setId(id);
		getDeveloperDao().delete(developer);
	}

}
