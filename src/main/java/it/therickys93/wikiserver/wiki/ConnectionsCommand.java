package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiserver.database.WikiDatabase;

public class ConnectionsCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			String response = db.getConnections(user_id);
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
