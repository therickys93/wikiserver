package it.therickys93.wikiserver.wiki;

import it.therickys93.wikiapi.controller.Off;
import it.therickys93.wikiapi.controller.WikiRequest;
import it.therickys93.wikiapi.model.Led;
import it.therickys93.wikiserver.database.WikiDatabase;
import it.therickys93.wikiserver.utils.CommandParser;

public class SwitchOffCommand implements Command {

	@Override
	public String execute(String request) {
		try {
			WikiDatabase db = new WikiDatabase();
			db.open();
			CommandParser pars = new CommandParser(request);
			Led led = db.get(pars.getArgument());
			db.close();
			WikiRequest wiki = new WikiRequest("http://192.168.15.16");
			wiki.execute(new Off(led));
			return "spento correttamente";
		} catch (Exception e){
			return "errore nello spegnimento";
		}
	}

}
