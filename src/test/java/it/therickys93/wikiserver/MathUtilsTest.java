package it.therickys93.wikiserver;

import static org.junit.Assert.*;

import org.junit.Test;

import it.therickys93.wikiserver.utils.MathUtils;

public class MathUtilsTest {

	@Test
	public void testMin(){
		assertEquals(1, MathUtils.min(1, 2));
		assertEquals(1, MathUtils.min(2, 1));
	}
	
	@Test
	public void testMax(){
		assertEquals(2, MathUtils.max(1, 2));
		assertEquals(2, MathUtils.max(2, 1));
	}
	
	@Test
	public void testNumberIsBetween(){
		assertTrue(MathUtils.numberIsBetween(1, 0, 2));
		assertFalse(MathUtils.numberIsBetween(0, 1, 2));
	}
	
	@Test
	public void testImproveCodeCoverage(){
		MathUtils math = new MathUtils();
		assertNotNull(math.toString());
	}
	
}
