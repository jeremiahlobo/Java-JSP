package webservice;
import java.lang.reflect.Type;
import java.util.List;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Customer;

//specify path fragment for jersey service to find this class 1
@Path("customers")

// http://localhost:8080/api.travelexperts.com/rest/customers/getcustomer/5


//this /rest was referenced in the web.xml 
public class Customers {
	
	@GET
	@Path("getcustomer/{custId}") //directory path fragment, {} tells it its gonna be an incoming url 2
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomer(@PathParam("custId") int customerId)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
				EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		String sql = "select c from Customer c where c.customerId= " + customerId; //case sensitive, one is referring to Agent class, the other is our param 5
		Query query = em.createQuery(sql); //attach the em to createQuery 6
		Customer customer = (Customer) query.getSingleResult();
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<Customer>() {}.getType();//type is import java.lang.reflect
		String jsonString = gson.toJson(customer, type);
		em.close();
		factory.close();
		return jsonString;		
	
	}
	
	//http://localhost:8080/api.travelexperts.com/rest/customer/getallcustomers	
	@GET //still a get operation
	@Path("getallcustomers") //no longer requires path param
	@Produces(MediaType.APPLICATION_JSON) //produces a json string
	public String getAllCustomers() //changed to get all agents 
	{
		
	//there will be a few minor changes here 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
		EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		String sql = "select c from Customer c"; //case sensitive, one is referring to Agent class, the other is our param 5
		Query query = em.createQuery(sql); //attach the em to createQuery 6
		List<Customer> customers = query.getResultList();//change to result list, list is java util package
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<List<Customer>>() {}.getType();//we are no longer getting agent, we are getting list of agents
		String jsonString = gson.toJson(customers, type); //list to gson
		em.close();
		factory.close();
		return jsonString;
	}
	
	//http://localhost:8080/api.travelexperts.com/rest/customers/postcustomer	
	@POST
	@Path("editProfile")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.TEXT_PLAIN)
	public String postCustomer(String jsonString)
	{
		
		Gson gson = new Gson();
		Type type = new TypeToken<Customer>() {}.getType();
		Customer customer = gson.fromJson(jsonString, type);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com");
		EntityManager em = factory.createEntityManager(); //entity sends object to database
		em.getTransaction().begin(); //kind of like getting a session
		em.persist(customer); //update object on database
		em.getTransaction().commit();//everything is temporary until commit. 
		return "customer updated"; 
	
	}
	
	
	//http://localhost:8080/api.travelexperts.com/rest/customers/postcustomer	
		@POST
		@Path("login")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Boolean loginCustomer(@FormParam("username") String username,@FormParam("password") String password)
		{
			System.out.println(username);
			System.out.println(password);
			
			Boolean Validated = false;
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com");
			EntityManager em = factory.createEntityManager();
			String select = "SELECT c FROM Customer c WHERE c.username=:username AND c.password=:password";

			Query query = em.createQuery(select);
			query.setParameter("username", username);
			query.setParameter("password", password);
			
			
			try 
			{
				Customer cust = (Customer) query.getSingleResult();
				if (cust.equals(null)) 
				{
					System.out.println(cust);
					Validated = false;
				}else {
					System.out.println(cust);
					Validated = true;
				}
			}catch(NoResultException ne) {
				Validated = false;
				
			}
			
		    return Validated;
		
		}
	
}
