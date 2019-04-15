package webservice;
import java.lang.reflect.Type;
import java.util.List;

import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Agent;

//specify path fragment for jersey service to find this class 1
@Path("agents")

// http://localhost:8080/api.travelexperts.com/rest/agents/getagent/5


//this /rest was referenced in the web.xml 
public class Agents {
	
	@GET
	@Path("getagent/{ agentid }") //directory path fragment, {} tells it its gonna be an incoming url 2
	@Produces(MediaType.APPLICATION_JSON)
	public String getAgent(@PathParam("agentid") int agentid)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
				EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		String sql = "select a from Agent a where a.agentId=" + agentid; //case sensitive, one is referring to Agent class, the other is our param 5
		Query query = em.createQuery(sql); //attach the em to createQuery 6
		Agent agent = (Agent) query.getSingleResult();
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<Agent>() {}.getType();//type is import java.lang.reflect
		String jsonString = gson.toJson(agent, type);
		em.close();
		factory.close();
		return jsonString;
		
				
	
	}
	//http://localhost:8080/JSPDay7/rest/agents/getallagents	
	@GET //still a get operation
	@Path("getallagents") //no longer requires path param
	@Produces(MediaType.APPLICATION_JSON) //produces a json string
	public String getAllAgents() //changed to get all agents 
	{
		
	//there will be a few minor changes here 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
		EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		String sql = "select a from Agent a"; //case sensitive, one is referring to Agent class, the other is our param 5
		Query query = em.createQuery(sql); //attach the em to createQuery 6
		List<Agent> agents = query.getResultList();//change to result list, list is java util package
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<List<Agent>>() {}.getType();//we are no longer getting agent, we are getting list of agents
		String jsonString = gson.toJson(agents, type); //list to gson
		em.close();
		factory.close();
		return jsonString;
	}
	//http://localhost:8080/JSPDay7/rest/agents/postAgent	
	@POST
	@Path("postagent")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.TEXT_PLAIN)
	public String postAgent(String jsonString)
	{
		Gson gson = new Gson();
		Type type = new TypeToken<Agent>() {}.getType();
				Agent agent = gson.fromJson(jsonString, type);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com");
		EntityManager em = factory.createEntityManager(); //entity sends object to database
		em.getTransaction().begin(); //kind of like getting a session
		em.persist(agent); //update object on database
		em.getTransaction().commit();//everything is temporary until commit. 
		return "agent updated"; 
	
	}
}
