package it.therickys93.wikiserver.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class WikiServerVersionOne extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
				
		router.attach("/echo", EchoResource.class);
		getLogger().info("Started " + EchoResource.class.toString() + " @ /v1/echo");
		
		router.attach("/wiki", WikiResource.class);
		getLogger().info("Started " + WikiResource.class.toString() + " @ /v1/wiki");
		
		
		return router;
	}
	
}
