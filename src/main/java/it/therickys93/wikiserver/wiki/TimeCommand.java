package it.therickys93.wikiserver.wiki;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		Locale.setDefault(Locale.ITALIAN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		String date = dateFormat.format(new Date());
		return "sono le " + date;
	}

}
