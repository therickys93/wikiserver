package it.therickys93.wikiserver.wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			result += "Controller: " + response + " ";
	        Process p = Runtime.getRuntime().exec("git describe --abbrev=0 --tags");
	        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line; 
	        while ((line = input.readLine()) != null)
	        {
	            result += "Server: " + line;
	        }
		} catch (IOException e){
			e.printStackTrace();
			result = "Errore nella versione";
		}
		
		return result;
	}

}
