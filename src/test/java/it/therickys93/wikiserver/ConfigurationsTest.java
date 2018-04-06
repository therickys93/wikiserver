package it.therickys93.wikiserver;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import it.therickys93.wikiserver.utils.Configurations;

public class ConfigurationsTest {

	@Rule
	public final EnvironmentVariables environmentVariables = new EnvironmentVariables();
	
	@Test
	public void testHost() {
		assertEquals("localhost", Configurations.host());
		environmentVariables.set("WIKISERVER_HOST", "192.168.0.2");
		assertEquals("192.168.0.2", Configurations.host());
	}
	
	@Test
	public void testPort() {
		assertEquals(8080, Configurations.port());
		environmentVariables.set("WIKISERVER_PORT", "8081");
		assertEquals(8081, Configurations.port());
	}
	
	@Test
	public void testWoeid(){
		assertEquals("716231", Configurations.woeid());
		environmentVariables.set("WIKISERVER_WOEID", "718345");
		assertEquals("718345", Configurations.woeid());
	}
	
	@Test
	public void testImproveCodeCoverage(){
		Configurations conf = new Configurations();
		conf.toString();
	}
	
}
