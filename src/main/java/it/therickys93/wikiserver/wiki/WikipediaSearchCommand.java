package it.therickys93.wikiserver.wiki;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class WikipediaSearchCommand implements Command {
	
	@Override
	public String execute(String message, String user_id) {
		String [] arr = message.split(" ", 2);
		String search = arr[1];
		Client client = new Client(new Context(), Protocol.HTTP);
		ClientResource clientResource = new ClientResource("https://it.wikipedia.org/w/api.php?action=opensearch&search="+search+"&limit=1&format=json");
		clientResource.setNext(client);
		Representation respresentation = null;
		String json = null;
		String result = "Non ho trovato quello che cercavi";
		try {
			respresentation = clientResource.get();
			json = respresentation.getText();
			JsonParser parser = new JsonParser();
			JsonArray array = (JsonArray) parser.parse(json);
			result = array.get(2).getAsString();
			return result;
		} catch (Exception e){
			// e.printStackTrace();
		}
		return result;
	}
}
