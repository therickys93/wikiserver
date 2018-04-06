package it.therickys93.wikiserver.wiki;

public class HowAreYouCommand implements Command {

	@Override
	public String execute(String request) {
		return "bene, grazie";
	}

}
