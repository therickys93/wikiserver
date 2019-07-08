package it.therickys93.wikiserver.wiki;

import java.io.IOException;

import it.therickys93.wikiapi.controller.Version;
import it.therickys93.wikiapi.controller.WikiController;
import it.therickys93.wikiserver.utils.Configurations;

public class VersionCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		
		String result = "";
		try {
			WikiController wikicontroller = new WikiController(Configurations.wikiControllerURL());
			String response = wikicontroller.execute(new Version());
			result += "Controller: " + response;
		} catch (IOException e){
			result = "Errore nella versione";
		}
		
		return result;
	}

}
