package it.therickys93.wikiserver.wiki;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WikiRequest {

	public static String getMessage(String request) {
		try {
			JsonParser parser = new JsonParser();
			JsonObject jsonRequest = (JsonObject) parser.parse(request);
			String message = jsonRequest.get("request").getAsString();
			return message;
		} catch (Exception e){
			return null;
		}
		
	}

}
