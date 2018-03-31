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
	public void testRequest() {
		assertEquals("ciao", WikiRequest.getMessage("{\"request\":\"ciao\"}"));
		assertNull(WikiRequest.getMessage(""));
	}
	
	@Test
	public void testResponse() {
		assertEquals(createWikiResponse("ciao"), WikiResponse.sendMessage("ciao"));
	}
	
	@Test
	public void testImproveCodeCoverage() {
		WikiRequest request = new WikiRequest();
		request.toString();
		WikiResponse response = new WikiResponse();
		response.toString();
	}
	
	private Map<String, String> createWikiResponse(String message) {
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", message);
		return response;
	}

}
