package it.therickys93.wikiserver.wiki;

public class HelloCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		String response = "ciao";
		return response;
	}

}
