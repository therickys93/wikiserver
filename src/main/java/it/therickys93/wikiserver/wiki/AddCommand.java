package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;
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
			db.close();
			return "aggiunto correttamente";
		} catch (Exception e){
			return "errore nell'aggiunta";
		}
	}

}
