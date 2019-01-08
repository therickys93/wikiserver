package it.therickys93.wikiserver.server;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import it.therickys93.wikiapi.controller.WikiRequest;
import it.therickys93.wikiapi.controller.WikiResponse;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.wiki.WikiAI;

public class WikiVersionTwoResource extends ServerResource {
	
	@Post
	public Map<String, String> update(Representation data) throws IOException {
		
		
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			String request = data.getText();
			getLogger().info(request);
			
			List<String> fromClient = WikiRequest.readMessageWithUserID(request);
			getLogger().info(fromClient.toString());
			
			db.insertRequestMessageWithUserID("/v2/wiki", fromClient.get(0), fromClient.get(1));
			
			String toClient = new WikiAI.Builder().build().reply(fromClient.get(0).toLowerCase());
			getLogger().info(toClient);
			
			db.insertResponseMessageWithUserID("/v2/wiki", toClient, fromClient.get(1));
			
			db.close();
			return WikiResponse.sendMessage(toClient);
		} catch (Exception e){
			return WikiResponse.sendMessage("Errore nel database");
		}
	}

}
