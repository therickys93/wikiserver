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
			String response = "";
			if(db.remove(pars.getArgument())){
				response = "rimosso correttamente";
			} else {
				response = "nulla da rimuovere";
			}
			db.close();
			return response;
		} catch (Exception e){
			return "errore nella rimozione";
		}
	}

}
