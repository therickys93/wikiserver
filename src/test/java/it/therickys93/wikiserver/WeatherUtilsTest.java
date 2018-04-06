package it.therickys93.wikiserver;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.wikiserver.utils.WeatherUtils;

public class WeatherUtilsTest {

	@Test
	public void testError(){
		assertEquals("errore nel tempo", WeatherUtils.getString(32000));
	}
	
	@Test
	public void testNoData(){
		assertEquals("non sono disponibili i dati", WeatherUtils.getString(3200));
	}
	
	@Test
	public void testStaTempestando(){
		assertEquals("sta tempestando", WeatherUtils.getString(2));
	}
	
	@Test
	public void testStaDiluviando(){
		assertEquals("sta diluviando", WeatherUtils.getString(4));
		assertEquals("sta diluviando", WeatherUtils.getString(38));
		assertEquals("sta diluviando", WeatherUtils.getString(47));
	}
	
	@Test
	public void testStaNevicando(){
		assertEquals("sta nevicando", WeatherUtils.getString(6));
		assertEquals("sta nevicando", WeatherUtils.getString(15));
		assertEquals("sta nevicando", WeatherUtils.getString(42));
		assertEquals("sta nevicando", WeatherUtils.getString(46));
	}
	
	@Test
	public void testStaPiovendoModeratamente(){
		assertEquals("sta piovendo moderatamente", WeatherUtils.getString(9));
	}
	
	@Test
	public void testStaPiovendo(){
		assertEquals("sta piovendo", WeatherUtils.getString(11));
		assertEquals("sta piovendo", WeatherUtils.getString(12));
		assertEquals("sta piovendo", WeatherUtils.getString(45));
	}
	
	@Test
	public void testStaGrandinando(){
		assertEquals("sta grandinando", WeatherUtils.getString(17));
		assertEquals("sta grandinando", WeatherUtils.getString(35));
	}
	
	@Test
	public void testStaNevischiando(){
		assertEquals("sta nevischiando", WeatherUtils.getString(18));
	}
	
	@Test
	public void testSiStaAnnebbiando(){
		assertEquals("si sta annebbiando", WeatherUtils.getString(22));
	}
	
	@Test
	public void testStaSoffiandoIlVento(){
		assertEquals("sta soffiando il vento", WeatherUtils.getString(24));
	}
	
	@Test
	public void testSiStaRaffreddando(){
		assertEquals("si sta raffreddando", WeatherUtils.getString(25));
	}
	
	@Test
	public void testSiStaAnnuvolando(){
		assertEquals("si sta annuvolando", WeatherUtils.getString(27));
	}
	
	@Test
	public void testStanotteCiSonoLeNuvole(){
		assertEquals("stanotte ci sono le nuvole", WeatherUtils.getString(29));
	}
	
	@Test
	public void testCiSonoNuvoleESole(){
		assertEquals("ci sono nuvole e sole", WeatherUtils.getString(30));
		assertEquals("ci sono nuvole e sole", WeatherUtils.getString(44));
	}
	
	@Test
	public void testStanotteNonCiSonoLeNuvole(){
		assertEquals("stanotte non ci sono le nuvole", WeatherUtils.getString(31));
		assertEquals("stanotte non ci sono le nuvole", WeatherUtils.getString(33));
	}
	
	@Test
	public void testIlSoleStaSplendendo(){
		assertEquals("il sole sta splendendo", WeatherUtils.getString(32));
		assertEquals("il sole sta splendendo", WeatherUtils.getString(34));
		assertEquals("il sole sta splendendo", WeatherUtils.getString(36));
	}
	
	@Test
	public void testImproveCodeCoverage(){
		WeatherUtils utils = new WeatherUtils();
		assertNotNull(utils.toString());
	}
	
}
