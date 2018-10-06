package it.therickys93.wikiserver.utils;

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

	public static String woeid() {
		if(System.getenv("WIKISERVER_WOEID") != null){
			return System.getenv("WIKISERVER_WOEID");
		} else {
			return "716231";
		}
	}

	public static String databaseHost() {
		if(System.getenv("WIKISERVER_DB_HOST") != null){
			return System.getenv("WIKISERVER_DB_HOST");
		} else {
			return "localhost";
		}
	}

	public static String databasePort() {
		if(System.getenv("WIKISERVER_DB_PORT") != null){
			return System.getenv("WIKISERVER_DB_PORT");
		} else {
			return "5432";
		}
	}

	public static String databaseDatabase() {
		if(System.getenv("WIKISERVER_DB_DATABASE") != null){
			return System.getenv("WIKISERVER_DB_DATABASE");
		} else {
			return "wiki";
		}
	}

	public static String dbConnectionString() {
		return "jdbc:postgresql://" + Configurations.databaseHost() + ":" + Configurations.databasePort() + "/" + Configurations.databaseDatabase();
	}

	public static String wikiControllerURL() {
		if(System.getenv("WIKISERVER_CONTROLLER_URL") != null){
			return System.getenv("WIKISERVER_CONTROLLER_URL");
		} else {
			return "http://localhost";
		}
	}

	public static String dbUsername() {
		if(System.getenv("WIKISERVER_DB_USER") != null){
			return System.getenv("WIKISERVER_DB_USER");
		} else {
			return "postgres";
		}
	}

	public static String dbPassword() {
		if(System.getenv("WIKISERVER_DB_PASSWORD") != null){
			return System.getenv("WIKISERVER_DB_PASSWORD");
		} else {
			return "example";
		}
	}

	public static String qrcodeUrl() {
		if(System.getenv("WIKISERVER_QR_CODE") != null){
			return System.getenv("WIKISERVER_QR_CODE");
		} else {
			return "http://server.wiki.home";
		}
	}
}
