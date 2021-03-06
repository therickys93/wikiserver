package it.therickys93.wikiserver.server;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.service.LogService;

import it.therickys93.wikiserver.utils.Configurations;

public class Server {
	private final Component component;
	
	public Server(){
		component = new Component();
		component.getServers().add(Protocol.HTTP, Configurations.port());
		component.getDefaultHost().attach("/", new WikiServer());
		component.getDefaultHost().attach("/v0", new WikiServerVersionZero());
		component.getDefaultHost().attach("/v1", new WikiServerVersionOne());
		component.getDefaultHost().attach("/v2", new WikiServerVersionTwo());
		component.setLogService(new LogService(false));
		component.getLogger().info("Server started @ http://" + Configurations.host() + ":" + Configurations.port());
	}
	
	public void start() throws Exception {
		component.start();
	}
		
	public void stop() throws Exception {
		component.stop();
	}
	
	public static void main(String[] args) throws Exception{
		final Server server = new Server();
		server.start();
	}
}
