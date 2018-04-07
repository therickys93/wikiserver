package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiapi.controller.Reset;
import it.therickys93.wikiapi.controller.WikiRequest;
import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;
import it.therickys93.wikiserver.utils.Configurations;
import it.therickys93.wikiserver.utils.DatabaseParser;

public class AddCommand implements Command {

	@Override
	public String execute(String request) {

		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(request);
			DatabaseParser parser = new DatabaseParser(pars.getArgument());
			Led led = parser.getLed();
			db.insert(led);
			int dbCount = db.count(led.getKey());
			db.close();
			if(dbCount == 1){
				WikiRequest wiki = new WikiRequest(Configurations.wikiControllerURL());
				wiki.execute(new Reset(led.getKey()));
			}
			return "aggiunto correttamente";
		} catch (Exception e){
			return "errore nell'aggiunta";
		}
	}

}
