package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;

public class RemoveCommand implements Command {

	@Override
	public String execute(String request) {
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(request);
			db.remove(pars.getArgument());
			db.close();
			return "rimosso correttamente";
		} catch (Exception e){
			return "errore nell'aggiunta";
		}
	}

}
