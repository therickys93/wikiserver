package it.therickys93.wikiserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import it.therickys93.wikiserver.wiki.WikiRequest;
import it.therickys93.wikiserver.wiki.WikiResponse;

public class WikiRequestAndResponseTest {
	
	@Test
	public void testOne() {
		assertEquals("ciao", WikiRequest.getMessage("{\"request\":\"ciao\"}"));
		assertNull(WikiRequest.getMessage(""));
	}
	
	@Test
	public void testTwo() {
		assertEquals(createWikiResponse("ciao"), WikiResponse.sendMessage("ciao"));
	}
	
	private Map<String, String> createWikiResponse(String message) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", message);
		return response;
	}

}
