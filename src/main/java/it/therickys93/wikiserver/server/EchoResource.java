package it.therickys93.wikiserver.server;

import java.io.IOException;
import java.util.Map;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import it.therickys93.wikiapi.controller.WikiRequest;
import it.therickys93.wikiapi.controller.WikiResponse;
import it.therickys93.wikiserver.database.WikiDatabase;

public class EchoResource extends ServerResource {

	@Post
	public Map<String, String> update(Representation data) throws IOException {
		
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			// the request should be something like that
			// {"request": "ciao"}
			String coming = data.getText();
			getLogger().info(coming);
			
			db.insertRequestMessage("/v1/echo", coming);
			
			String message = WikiRequest.readMessage(coming);
			getLogger().info(message);
			
			db.insertResponseMessage("/v1/echo", message);
			db.close();
		
			// the response should be something like that
			// {"response": "ciao"}
			return WikiResponse.sendMessage(message);
		} catch (Exception e){
			return WikiResponse.sendMessage("Errore nel database");
		}
	}
	
}
