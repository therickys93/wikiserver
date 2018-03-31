package it.therickys93.wikiserver.server;

public class Configurations {

	public static int port() {
		if(System.getenv("WIKISERVER_PORT") != null) {
			return Integer.parseInt(System.getenv("WIKISERVER_PORT"));
		} else {
			return 8080;
		}
	}
	
	public static String host() {
		if(System.getenv("WIKISERVER_HOST") != null) {
			return System.getenv("WIKISERVER_HOST");
		} else {
			return "localhost";
		}
	}
}
