package it.therickys93.wikiserver.wiki;

public interface Command {
	public String execute(String message, String user_id);
}
