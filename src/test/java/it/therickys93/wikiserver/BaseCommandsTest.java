package it.therickys93.wikiserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.therickys93.wikiserver.wiki.CalculatorCommand;
import it.therickys93.wikiserver.wiki.ConfirmCommand;
import it.therickys93.wikiserver.wiki.DateCommand;
import it.therickys93.wikiserver.wiki.HelloCommand;
import it.therickys93.wikiserver.wiki.HowAreYouCommand;
import it.therickys93.wikiserver.wiki.InvalidCommand;
import it.therickys93.wikiserver.wiki.ThankYouCommand;
import it.therickys93.wikiserver.wiki.TimeCommand;
import it.therickys93.wikiserver.wiki.WhatIsYourNameCommand;

public class BaseCommandsTest {

	@Test
	public void testHelloCommand() {
		HelloCommand hello = new HelloCommand();
		assertEquals("ciao", hello.execute(request(), "pippo"));
	}
	
	@Test
	public void testConfirmCommand(){
		ConfirmCommand confirm = new ConfirmCommand();
		assertEquals("comando confermato", confirm.execute(request(), "pippo"));
	}
	
	@Test
	public void testInvalidCommand(){
		InvalidCommand invalid = new InvalidCommand();
		assertEquals("Non ho capito. Ripeti per favore", invalid.execute(request(), "pippo"));
	}
	
	@Test
	public void testThankYouCommand(){
		ThankYouCommand thank = new ThankYouCommand();
		assertEquals("prego", thank.execute(request(), "pippo"));
	}
	
	@Test
	public void testDateCommand(){
		DateCommand date = new DateCommand();
		assertNotNull(date.execute(request(), "pippo"));
	}
	
	@Test
	public void testTimeCommand(){
		TimeCommand time = new TimeCommand();
		assertNotNull(time.execute(request(), "pippo"));
	}
	
	@Test
	public void testHowAreYouCommand(){
		HowAreYouCommand command = new HowAreYouCommand();
		assertEquals("bene, grazie", command.execute(request(), "pippo"));
	}
	
	@Test
	public void testWhatIsYourNameCommand(){
		WhatIsYourNameCommand command = new WhatIsYourNameCommand();
		assertEquals("il mio nome è Wiki", command.execute(request(), "pippo"));
	}
	
	@Test
	public void testCalculatorCommand(){
		CalculatorCommand calc = new CalculatorCommand();
		assertEquals("il risultato è 9", calc.execute("calcola 5 + 4", "pippo"));
		assertEquals("Errore nel calcolo", calc.execute("calcola bella", "pippo"));
	}
	
	private String request(){
		return "";
	}
	
}
