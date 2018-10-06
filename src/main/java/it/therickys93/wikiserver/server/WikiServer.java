package it.therickys93.wikiserver.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class WikiServer extends Application {

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		
		// GET / --> semplice pagina web
		router.attach("", IndexResource.class);
		getLogger().info("Started " + IndexResource.class.toString() + " @ /");
		
		// GET /qrcode --> pagina che mostra il qrcode dell'indirizzo
		router.attach("qrcode", QRCodeIndexResource.class);
		getLogger().info("Started " + QRCodeIndexResource.class.toString() + " @ /qrcode");
		
		return router;
	}
	
}
