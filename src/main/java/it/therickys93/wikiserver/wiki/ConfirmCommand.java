package it.therickys93.wikiserver.wiki;

public class ConfirmCommand implements Command {

	@Override
	public String execute(String request) {
		String output = "comando confermato";
		return output;
	}

}
