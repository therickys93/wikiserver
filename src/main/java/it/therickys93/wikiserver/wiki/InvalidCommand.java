package it.therickys93.wikiserver.wiki;

public class InvalidCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		String response = "Non ho capito. Ripeti per favore";
		return response;
	}
}
