package it.therickys93.wikiserver.server;

import java.io.IOException;
import java.util.Map;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import it.therickys93.wikiserver.wiki.WikiAI;
import it.therickys93.wikiserver.wiki.WikiRequest;
import it.therickys93.wikiserver.wiki.WikiResponse;

public class WikiResource extends ServerResource {
	
	@Post
	public Map<String, String> update(Representation data) throws IOException {
		
		String request = data.getText();
		getLogger().info(request);
		
		String fromClient = WikiRequest.getMessage(request);
		getLogger().info(fromClient);
		
		String toClient = new WikiAI.Builder().build().reply(fromClient);
		getLogger().info(toClient);
		
		return WikiResponse.sendMessage(toClient);
	}

}
