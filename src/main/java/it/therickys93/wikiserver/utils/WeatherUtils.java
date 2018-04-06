package it.therickys93.wikiserver.utils;

public class WeatherUtils {

	public static String getString(int code) {
		if(code == 3200){
			return "non sono disponibili i dati";
		}
		if(MathUtils.numberIsBetween(code, 0, 3)){
			return "sta tempestando";
		}
		if(code == 4 || MathUtils.numberIsBetween(code, 37, 40) || code == 47){
			return "sta diluviando";
		}
		if(MathUtils.numberIsBetween(code, 5, 7) || MathUtils.numberIsBetween(code, 41, 43) || code == 46) {
			return "sta nevicando";
		}
		if(MathUtils.numberIsBetween(code, 8, 10)) {
			return "sta piovendo moderatamente";
		}
		if(code == 11 || code == 12 || code == 45){
			return "sta piovendo";
		}
		if(MathUtils.numberIsBetween(code, 13, 16)) {
			return "sta nevicando";
		}
		if(code == 17 || code == 35){
			return "sta grandinando";
		}
		if(code == 18){
			return "sta nevischiando";
		}
		if(MathUtils.numberIsBetween(code, 19, 23)){
			return "si sta annebbiando";
		}
		if(code == 24){
			return "sta soffiando il vento";
		}
		if(code == 25){
			return "si sta raffreddando";
		}
		if(MathUtils.numberIsBetween(code, 26, 28)){
			return "si sta annuvolando";
		}
		if(code == 29){
			return "stanotte ci sono le nuvole";
		}
		if(code == 30 || code == 44){
			return "ci sono nuvole e sole";
		}
		if(code == 31 || code == 33){
			return "stanotte non ci sono le nuvole";
		}
		if(code == 32 || code == 34 || code == 36){
			return "il sole sta splendendo";
		}
		return "errore nel tempo";
	}
	
}
