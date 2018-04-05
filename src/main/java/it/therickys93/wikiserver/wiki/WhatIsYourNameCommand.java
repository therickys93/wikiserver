package it.therickys93.wikiserver.wiki;

public class WhatIsYourNameCommand implements Command {

	@Override
	public String execute(String request) {
		return "il mio nome è Wiki";
	}

}
