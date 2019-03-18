package it.therickys93.wikiserver;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiapi.model.Sensor;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.DatabaseParser;

public class ParserTest {

	@Test
	public void testParserWithNumber(){
		CommandParser parser = new CommandParser("aggiungi luce cucina in cucina alla presa 10");
		assertEquals("aggiungi", parser.getCommand());
		assertEquals("luce cucina in cucina alla presa 10", parser.getArgument());
		DatabaseParser db = new DatabaseParser(parser.getArgument());
		Led led = db.getLed();
		assertEquals("luce cucina", led.getName());
		assertEquals("cucina", led.getKey());
		assertEquals(10, led.getPosition());
		Sensor sensor = db.getSensor();
		assertEquals("luce cucina", sensor.getName());
	}
	
	@Test
	public void testParserWithOne(){
		CommandParser parser = new CommandParser("aggiungi luce cucina in cucina alla presa uno");
		assertEquals("aggiungi", parser.getCommand());
		assertEquals("luce cucina in cucina alla presa uno", parser.getArgument());
		DatabaseParser db = new DatabaseParser(parser.getArgument());
		Led led = db.getLed();
		assertEquals("luce cucina", led.getName());
		assertEquals("cucina", led.getKey());
		assertEquals(1, led.getPosition());
	}
	
	@Test
	public void testParserWithTwo(){
		CommandParser parser = new CommandParser("aggiungi luce cucina in cucina alla presa due");
		assertEquals("aggiungi", parser.getCommand());
		assertEquals("luce cucina in cucina alla presa due", parser.getArgument());
		DatabaseParser db = new DatabaseParser(parser.getArgument());
		Led led = db.getLed();
		assertEquals("luce cucina", led.getName());
		assertEquals("cucina", led.getKey());
		assertEquals(2, led.getPosition());
	}
	
}
