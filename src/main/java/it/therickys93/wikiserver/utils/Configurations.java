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

	public static String connectionString() {
		return "jdbc:postgresql://" + Configurations.databaseHost() + ":" + Configurations.databasePort() + "/" + Configurations.databaseDatabase();
	}
}
