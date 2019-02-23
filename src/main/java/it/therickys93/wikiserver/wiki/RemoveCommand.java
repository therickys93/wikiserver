package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;

public class RemoveCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(message);
			String response = "";
			if(db.removeLed(pars.getArgument(), user_id)){
				response = "rimosso correttamente";
			} else {
				response = "nulla da rimuovere";
				if(db.removeSensor(pars.getArgument(), user_id)){
					response = "rimosso correttamente";
				} else {
					response = "nulla da rimuovere";
				}
			}
			db.close();
			return response;
		} catch (Exception e){
			return "errore nella rimozione";
		}
	}

}
