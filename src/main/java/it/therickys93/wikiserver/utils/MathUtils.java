package it.therickys93.wikiserver.utils;

public class MathUtils {

	public static int min(int i, int j) {
		return (i < j) ? i : j;
	}

	public static int max(int i, int j) {
		return (i > j) ? i : j;
	}

	public static boolean numberIsBetween(int number, int min, int max) {
		return MathUtils.max(number, min) == MathUtils.min(number, max);
	}
	
}
