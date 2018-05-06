package it.therickys93.wikiserver.wiki;

import java.io.IOException;
import java.sql.SQLException;

import it.therickys93.wikiapi.controller.Off;
import it.therickys93.wikiapi.controller.WikiController;
import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.Configurations;

public class SwitchOffCommand implements Command {

	@Override
	public String execute(String request) {
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(request);
			Led led = db.get(pars.getArgument());
			db.close();
			WikiController wiki = new WikiController(Configurations.wikiControllerURL());
			wiki.execute(new Off(led));
			return "spento correttamente";
		} catch (SQLException e){
			return "errore nel database";
		} catch (IOException e){
			return "errore nello spegnimento";
		}
	}

}
