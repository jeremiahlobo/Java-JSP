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

import model.Package;

//specify path fragment for jersey service to find this class 1
@Path("packages")

// http://localhost:8080/api.travelexperts.com/rest/packages/getallpackages

//this /rest was referenced in the web.xml 
public class Packages {
	
	@GET
	@Path("getpackage/{ packageid }") //directory path fragment, {} tells it its gonna be an incoming url 2
	@Produces(MediaType.APPLICATION_JSON)
	public String getPackage(@PathParam("packageid") int packageid)
	{
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
				EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		String sql = "select p from Package p where p.packageId=" + packageid; //case sensitive, one is referring to Agent class, the other is our param 5
		Query query = em.createQuery(sql); //attach the em to createQuery 6
		Package pack = (Package) query.getSingleResult();
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<Package>() {}.getType();//type is import java.lang.reflect
		String jsonString = gson.toJson(pack, type);
		em.close();
		factory.close();
		return jsonString;
	
	}
	
	//http://localhost:8080/api.travelexperts.com/rest/packages/getallpackages
	@GET //still a get operation
	@Path("getallpackages") //no longer requires path param
	@Produces(MediaType.APPLICATION_JSON) //produces a json string
	public String getAllPackages() //changed to get all agents 
	{
		System.out.println("working");
	//there will be a few minor changes here 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
		EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		String sql = "select p from Package p"; //case sensitive, one is referring to Agent class, the other is our param 5
		Query query = em.createQuery(sql); //attach the em to createQuery 6
		List<Package> packages = query.getResultList();//change to result list, list is java util package
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<List<Packages>>() {}.getType();//we are no longer getting agent, we are getting list of agents
		String jsonString = gson.toJson(packages, type); //list to gson
		em.close();
		factory.close();
		return jsonString;
	}
}
