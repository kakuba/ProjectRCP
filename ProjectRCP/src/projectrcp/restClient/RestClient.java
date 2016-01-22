package projectrcp.restClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.google.gson.Gson;

import projectrcp.model.BookTo;

public class RestClient {
	private Gson gson;
	
	public RestClient() {
		gson = new Gson();
	}
	
	public Collection<BookTo> search(String title) {
		if(title == "" || title == null) {
			title = " ";
		}
		
		Collection<BookTo> bookCollection = new ArrayList<>();
		ClientConfig config = new ClientConfig();
		
		Client client = ClientBuilder.newClient(config);
		
		WebTarget target = client.target(getBaseURI()).path("books-by-title").queryParam("titlePrefix", title);
		
		String response = target.request(MediaType.APPLICATION_JSON).get(Response.class).readEntity(String.class);
		
		BookTo[] bookArray = gson.fromJson(response, BookTo[].class);

		for (BookTo book : bookArray) {
			bookCollection.add(book);
		}


		return bookCollection;

	}
	
	public void add(BookTo book) {
		if (book != null) {
			String input = gson.toJson(book);
			ClientConfig config = new ClientConfig();
			
			Client client = ClientBuilder.newClient(config);
			
			WebTarget target = client.target(getBaseURI()).path("book");
			
			target.request(MediaType.APPLICATION_JSON).post(Entity.entity(input,MediaType.APPLICATION_JSON),Response.class);
		}
	}
	public void update(BookTo book) {
		if (book != null) {
			String input = gson.toJson(book);
			ClientConfig config = new ClientConfig();
			
			Client client = ClientBuilder.newClient(config);
			
			WebTarget target = client.target(getBaseURI()).path("book");
			
			target.request(MediaType.APPLICATION_JSON).put(Entity.entity(input,MediaType.APPLICATION_JSON),Response.class);
		}
	}
	
	public void delete(Long id) {
		if (id != null) {
			ClientConfig config = new ClientConfig();
			
			Client client = ClientBuilder.newClient(config);
			
			WebTarget target = client.target(getBaseURI()).path("book").queryParam("id", id);
			
			target.request(MediaType.APPLICATION_JSON).delete();
		}
	}
	
	
	
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:9721/workshop").build();
	  }
}
