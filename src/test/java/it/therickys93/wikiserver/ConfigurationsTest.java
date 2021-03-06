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
	public void testPostgresHost(){
		assertEquals("localhost", Configurations.databaseHost());
		environmentVariables.set("WIKISERVER_DB_HOST", "postgres");
		assertEquals("postgres", Configurations.databaseHost());
	}
	
	@Test
	public void testPostgresPort(){
		assertEquals("5432", Configurations.databasePort());
		environmentVariables.set("WIKISERVER_DB_PORT", "1234");
		assertEquals("1234", Configurations.databasePort());
	}
	
	@Test
	public void testPostgresDatabase(){
		assertEquals("wiki", Configurations.databaseDatabase());
		environmentVariables.set("WIKISERVER_DB_DATABASE", "bella");
		assertEquals("bella", Configurations.databaseDatabase());
	}
	
	@Test
	public void testPostgresConnectionString(){
		assertEquals("jdbc:postgresql://localhost:5432/wiki", Configurations.dbConnectionString());
		environmentVariables.set("WIKISERVER_DB_HOST", "postgres");
		environmentVariables.set("WIKISERVER_DB_PORT", "1234");
		environmentVariables.set("WIKISERVER_DB_DATABASE", "bella");
		assertEquals("jdbc:postgresql://postgres:1234/bella", Configurations.dbConnectionString());
	}
	
	@Test
	public void testWikiControllerURL(){
		assertEquals("http://localhost", Configurations.wikiControllerURL());
		environmentVariables.set("WIKISERVER_CONTROLLER_URL", "http://controller");
		assertEquals("http://controller", Configurations.wikiControllerURL());
	}
	
	@Test
	public void testDBUsername(){
		assertEquals("postgres", Configurations.dbUsername());
		environmentVariables.set("WIKISERVER_DB_USER", "root");
		assertEquals("root", Configurations.dbUsername());
	}
	
	@Test
	public void testDBPassword(){
		assertEquals("example", Configurations.dbPassword());
		environmentVariables.set("WIKISERVER_DB_PASSWORD", "password");
		assertEquals("password", Configurations.dbPassword());
	}
	
	@Test
	public void testQRCode(){
		assertEquals("http://server.wiki.home", Configurations.qrcodeUrl());
		environmentVariables.set("WIKISERVER_QR_CODE", "server");
		assertEquals("server", Configurations.qrcodeUrl());
	}
	
	@Test
	public void testTelegramServerToken(){
		assertEquals("123", Configurations.telegramServerToken());
		environmentVariables.set("TELEGRAM_SERVER_TOKEN", "token");
		assertEquals("token", Configurations.telegramServerToken());
	}
	
	@Test
	public void testImproveCodeCoverage(){
		Configurations conf = new Configurations();
		conf.toString();
	}
	
}
