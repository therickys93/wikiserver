package it.therickys93.wikiserver.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class WikiServerVersionZero extends Application {
	
	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
				
		router.attach("/echo", EchoResource.class);
		getLogger().info("Started " + EchoResource.class.toString() + " @ /v0/echo");
		
		return router;
	}
	
}
