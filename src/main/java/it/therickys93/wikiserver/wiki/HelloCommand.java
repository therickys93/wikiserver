package it.therickys93.wikiserver.wiki;

public class HelloCommand implements Command {

	@Override
	public String execute(String request) {
		String response = "ciao";
		return response;
	}

}
