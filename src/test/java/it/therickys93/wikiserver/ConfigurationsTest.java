package it.therickys93.wikiserver;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.therickys93.wikiserver.utils.Configurations;

public class ConfigurationsTest {

	@Test
	public void testHost() {
		assertEquals("localhost", Configurations.host());
		System.setProperty("WIKISERVER_HOST", "192.168.0.2");
		assertEquals("192.168.0.2", Configurations.host());
	}
	
	@Test
	public void testPort() {
		assertEquals(8080, Configurations.port());
	}
	
	@Test
	public void testImproveCodeCoverage(){
		Configurations conf = new Configurations();
		conf.toString();
	}
	
}
