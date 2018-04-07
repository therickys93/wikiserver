package it.therickys93.wikiserver;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.DatabaseParser;

public class ParserTest {

	@Test
	public void testParseAdd(){
		CommandParser parser = new CommandParser("aggiungi luce cucina in cucina alla presa 10");
		assertEquals("aggiungi", parser.getCommand());
		assertEquals("luce cucina in cucina alla presa 10", parser.getArgument());
		DatabaseParser db = new DatabaseParser(parser.getArgument());
		Led led = db.getLed();
		assertEquals("luce cucina", led.getName());
		assertEquals("cucina", led.getKey());
		assertEquals(10, led.getPosition());
	}
	
}
