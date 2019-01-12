package it.therickys93.wikiserver;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import it.therickys93.wikiserver.wiki.Command;
import it.therickys93.wikiserver.wiki.HelloCommand;
import it.therickys93.wikiserver.wiki.WikiAI;

public class WikiAITest {

	@Test
	public void testOkCommand(){
		String request = "ciao";
		String response = new WikiAI.Builder().build().reply(request, "pippo");
		assertEquals("ciao", response);
	}
	
	@Test
	public void testWithCustomCommands(){
		String request = "ciao";
		String response = new WikiAI.Builder().withCommands(commands()).build().reply(request, "pippo");
		assertEquals("ciao", response);
	}
	
	@Test
	public void testInvalidCommand(){
		String request = "bella";
		String response = new WikiAI.Builder().build().reply(request, "pippo");
		assertEquals("Non ho capito. Ripeti per favore", response);
	}
	
	private Map<String, Command> commands(){
		Map<String, Command> commands = new HashMap<String, Command>();
		commands.put("ciao", new HelloCommand());
		return commands;
	}
	
}
