package service;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
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

	DeveloperDao developerDao ;
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager em;
	
	public DeveloperService() {
		 developerDao = new DeveloperDao();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Developer getDeveloper(@PathParam("id") int id) {
		Developer developer=developerDao.findById(id);
		System.out.println(developer.getId());
		return developer;
	}
	
	 @POST
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 @Produces(MediaType.APPLICATION_XML)
	 public Developer insertContact( @FormParam("name") String
	 name,@FormParam("surname") String surname) {
	
	 Developer developer = new Developer();
	 developer.setName(name);
	 developer.setSurname(surname);
	 developerDao.insert(developer);
	 return developer;
	
	 }


	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Developer> findAll() {
	 return developerDao.findAll();
	
	 }
	
	 @PUT
	 @Path("/{id}")
	 @Produces(MediaType.APPLICATION_XML)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Developer updateContact(@PathParam("id") int id,
	 @FormParam("name") String name,
	 @FormParam("surname") String surname, @FormParam("teamId") int teamId) {
	 Developer developer = new Developer();
	 developer.setId(id);
	 developer.setName(name);
	 developer.setSurname(surname);
	 developerDao.update(developer);
	 return developer;
	 }
	
	 @DELETE
	 @Path("/delete/{id}")
	 @Produces("text/plain")
	 public String deleteDeveloper(@PathParam("id") int id) {
	 developerDao.delete(id);
	 System.out.println("deleted");
	 return "deleted";
	 }
	 @DELETE
	 @Path("/deleteAll")
	 public String deleteAll() {
	 developerDao.deleteAll();
	 System.out.println("deleted");
	 return "deleted";
	 }
}
