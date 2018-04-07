package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiserver.database.WikiDatabase;

public class DBStatusCommand implements Command {

	@Override
	public String execute(String request) {
		
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			db.close();
			return "database ok";
		} catch (Exception e){
			return "errore di connessione al database";
		}
	}

}
