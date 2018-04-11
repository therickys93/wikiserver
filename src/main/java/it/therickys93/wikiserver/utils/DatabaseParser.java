package it.therickys93.wikiserver.utils;

import it.therickys93.wikiapi.model.Led;

public class DatabaseParser {

	private Led led;
	
	public DatabaseParser(String argument) {
		String tokens1[] = argument.split(" in ");
		String tokens2[] = tokens1[1].split(" alla presa ");
		this.led = new Led();
		this.led.setName(tokens1[0]);
		this.led.setKey(tokens2[0]);
		if(tokens2[1].contains("uno")){
			this.led.setPosition(1);
		} else if(tokens2[1].contains("due")){
			this.led.setPosition(2);
		} else {
			this.led.setPosition(Integer.parseInt(tokens2[1]));
		}
	}

	public Led getLed() {
		return this.led;
	}

}
