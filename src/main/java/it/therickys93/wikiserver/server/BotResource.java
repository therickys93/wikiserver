package it.therickys93.wikiserver.server;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class BotResource extends ServerResource {
	
	// needs to be implemented using a Telegram bot
	@Post
	public Representation update(Representation data) throws IOException {
		return null;
	}
}
