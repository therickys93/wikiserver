package it.therickys93.wikiserver.server;

import java.io.IOException;
import java.util.Map;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import it.therickys93.wikiapi.controller.WikiRequest;
import it.therickys93.wikiapi.controller.WikiResponse;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.wiki.WikiAI;

public class WikiResource extends ServerResource {
	
	@Post
	public Map<String, String> update(Representation data) throws IOException {
		
		
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			String request = data.getText();
			getLogger().info(request);
			
			String fromClient = WikiRequest.readMessage(request);
			getLogger().info(fromClient);
			
			db.insertRequestMessage("/v1/wiki", fromClient);
			
			String toClient = new WikiAI.Builder().build().reply(fromClient.toLowerCase());
			getLogger().info(toClient);
			
			db.insertResponseMessage("/v1/wiki", toClient);
			
			db.close();
			return WikiResponse.sendMessage(toClient);
		} catch (Exception e){
			return WikiResponse.sendMessage("Errore nel database");
		}
	}

}
