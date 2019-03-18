package it.therickys93.wikiserver.wiki;

import java.io.IOException;
import java.sql.SQLException;

import it.therickys93.wikiapi.controller.Response;
import it.therickys93.wikiapi.controller.Sensors;
import it.therickys93.wikiapi.controller.WikiController;
import it.therickys93.wikiapi.model.Sensor;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.Configurations;

public class SensorsCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(message);
			Sensor sensor = db.getSensor(pars.getArgument(), user_id);
			db.close();
			WikiController wiki = new WikiController(Configurations.wikiControllerURL());
			String response = wiki.execute(new Sensors(sensor));
			Response status = Response.parseSuccess(response);
			if (status == null) {
                return "errore nel sensore";
            } else {
                if (status.ok()) {
                    return status.message();
                } else {
                    return "errore nel sensore";
                }
            }
		} catch (SQLException e){
			return "errore nel database";
		} catch (IOException e){
			return "errore nello status";
		}
	}
	
}
