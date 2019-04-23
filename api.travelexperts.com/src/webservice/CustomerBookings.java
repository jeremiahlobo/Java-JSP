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

import model.Booking;
import model.Bookingdetail;

//specify path fragment for jersey service to find this class 1
@Path("customersbookings")

// http://localhost:8080/api.travelexperts.com/rest/customers/getcustomer/5


//this /rest was referenced in the web.xml 
public class CustomerBookings {
	
	@GET
	@Path("info/{custId}") //directory path fragment, {} tells it its gonna be an incoming url 2
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomerInfo(@PathParam("custId") int customerId)
	{
		System.out.println(customerId);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("api.travelexperts.com"); //using entitymanager factory and call factory with persistence, set up connection here in persistence xml
				EntityManager em = factory.createEntityManager(); //create an entity manager, call it em
		//create the query 4
		List<Object[]> results = em.createQuery("SELECT b, bd FROM Booking b INNER JOIN Bookingdetail bd ON b.bookingId = bd.bookingId WHERE b.customerId = "+customerId).getResultList();
		System.out.println(results);
		Gson gson = new Gson();
		//create a new type token object and specify class 
		Type type =  new TypeToken<List<Booking>>() {}.getType();//type is import java.lang.reflect
		String jsonString = gson.toJson(results, type);
		em.close();
		factory.close();
		return jsonString;		
	
	}
	
}
