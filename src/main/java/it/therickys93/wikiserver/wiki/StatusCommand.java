package it.therickys93.wikiserver.wiki;

import java.io.IOException;
import java.sql.SQLException;

import it.therickys93.wikiapi.controller.Response;
import it.therickys93.wikiapi.controller.Status;
import it.therickys93.wikiapi.controller.WikiController;
import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.Configurations;

public class StatusCommand implements Command {

	@Override
	public String execute(String request) {
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(request);
			Led led = db.get(pars.getArgument());
			db.close();
			WikiController wiki = new WikiController(Configurations.wikiControllerURL());
			String response = wiki.execute(new Status(led.getKey()));
			Response status = Response.parseSuccess(response);
			if (status == null) {
                return "errore nello stato";
            } else {
                if (status.ok()) {
                    if (status.message().charAt(led.getPosition() - 1) == '1') {
                        return "acceso";
                    } else {
                        return "spento";
                    }
                } else {
                    return "errore nello stato";
                }
            }
		} catch (SQLException e){
			return "errore nel database";
		} catch (IOException e){
			return "errore nello stato";
		}
	}

}
