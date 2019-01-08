package it.therickys93.wikiserver.wiki;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateCommand implements Command {

	@Override
	public String execute(String message, String user_id) {
		Locale.setDefault(Locale.ITALIAN);
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy");
		String date = dateFormat.format(new Date());
		return "oggi è " + date;
	}

}
