package it.therickys93.wikiserver.wiki;

public class HowAreYouCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		return "bene, grazie";
	}

}
