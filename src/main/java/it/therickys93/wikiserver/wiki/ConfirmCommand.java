package it.therickys93.wikiserver.wiki;

public class ConfirmCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		String output = "comando confermato";
		return output;
	}

}
