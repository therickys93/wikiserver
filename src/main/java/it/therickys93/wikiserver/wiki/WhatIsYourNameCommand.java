package it.therickys93.wikiserver.wiki;

public class WhatIsYourNameCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		return "il mio nome è Wiki";
	}

}
