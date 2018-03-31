package it.therickys93.wikiserver.wiki;

import java.util.HashMap;
import java.util.Map;

public class WikiResponse {

	public static Map<String, String> sendMessage(String message) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", message);
		return response;
	}

}
