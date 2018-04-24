package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiserver.database.WikiDatabase;

public class ConnectionsCommand implements Command {

	@Override
	public String execute(String request) {
		
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			String response = db.getConnections();
			db.close();
			if(response.isEmpty()){
				return "Nessuna connessione trovata";
			} else {
				return response;
			}
		} catch (Exception e){
			return "errore nella lettura";
		}
	}

}
