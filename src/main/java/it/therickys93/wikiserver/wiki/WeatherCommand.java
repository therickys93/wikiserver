package it.therickys93.wikiserver.wiki;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.unit.DegreeUnit;

import it.therickys93.wikiserver.utils.WeatherUtils;

public class WeatherCommand implements Command {

	// check you city woeid
	private static final String GIUSSANO_YAHOO_WOEID = "716231";

	@Override
	public String execute(String request) {
		
		try {
			YahooWeatherService service = new YahooWeatherService();
			int code = service.getForecast(GIUSSANO_YAHOO_WOEID, DegreeUnit.CELSIUS).getItem().getCondition().getCode();
			return "il meteo dice che " + WeatherUtils.getString(code);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		
		return "errore nel trovare il meteo";
	}

}
