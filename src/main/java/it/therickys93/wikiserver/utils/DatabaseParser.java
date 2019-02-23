package it.therickys93.wikiserver.utils;

import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiapi.model.Sensor;

public class DatabaseParser {

	private Led led;
	private Sensor sensor;
	
	public DatabaseParser(String argument) {
		String tokens1[] = argument.split(" in ");
		String tokens2[] = tokens1[1].split(" alla presa ");
		int position = 0;
		this.led = new Led();
		this.led.setName(tokens1[0]);
		this.led.setKey(tokens2[0]);
		if(tokens2[1].contains("uno")){
			this.led.setPosition(1);
			position = 1;
		} else if(tokens2[1].contains("due")){
			this.led.setPosition(2);
			position = 2;
		} else {
			this.led.setPosition(Integer.parseInt(tokens2[1]));
			position = Integer.parseInt(tokens2[1]);
		}
		this.sensor = new Sensor(tokens1[0], tokens2[0], position);
	}

	public Led getLed() {
		return this.led;
	}
	
	public Sensor getSensor() {
		return this.sensor;
	}

}
