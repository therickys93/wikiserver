package it.therickys93.wikiserver.wiki;

import java.io.IOException;
import java.sql.SQLException;

import it.therickys93.wikiapi.controller.Init;
import it.therickys93.wikiapi.controller.WikiController;
import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.Configurations;
import it.therickys93.wikiserver.utils.DatabaseParser;

public class AddCommand implements Command {

	@Override
	public String execute(String message, String user_id) {

		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(message);
			DatabaseParser parser = new DatabaseParser(pars.getArgument());
			Led led = parser.getLed();
			db.insert(led, user_id);
			int dbCount = db.countLed(led.getKey(), user_id);
			db.close();
			if(dbCount == 1){
				WikiController wiki = new WikiController(Configurations.wikiControllerURL());
				wiki.execute(new Init(led.getKey()));
			}
			return "aggiunto correttamente";
		} catch (SQLException e){
			return "errore nel database";
		} catch (IOException e){
			return "aggiunto correttamente solo nel database";
		}
	}

}
