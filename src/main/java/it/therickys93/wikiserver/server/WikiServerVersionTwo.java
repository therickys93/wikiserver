package it.therickys93.wikiserver.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class WikiServerVersionTwo extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
				
		router.attach("/echo", EchoResource.class);
		getLogger().info("Started " + EchoResource.class.toString() + " @ /v2/echo");
		
		router.attach("/wiki", WikiVersionTwoResource.class);
		getLogger().info("Started " + WikiVersionTwoResource.class.toString() + " @ /v2/wiki");
		
		router.attach("/qrcode", QRCodeVersionTwoResource.class);
		getLogger().info("Started " + QRCodeVersionTwoResource.class.toString() + " @ /v2/qrcode");
		
		return router;
	}

}
