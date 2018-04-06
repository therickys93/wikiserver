package it.therickys93.wikiserver.wiki;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WikiAI {

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public static class Builder {
		protected Map<String, Command> commands = new HashMap<String, Command>();
				
		public Builder()  {
			// create commands
			commands.put("ciao", new HelloCommand());
			commands.put("Ciao", new HelloCommand());
			commands.put("data", new DateCommand());
			commands.put("ore", new TimeCommand());
			commands.put("ora", new TimeCommand());
			commands.put("grazie", new ThankYouCommand());
			commands.put("Grazie", new ThankYouCommand());
			commands.put("conferma comando", new ConfirmCommand());
			commands.put("cerca", new WikipediaSearchCommand());
			commands.put("Cerca", new WikipediaSearchCommand());
			commands.put("calcola", new CalculatorCommand());
			commands.put("Calcola", new CalculatorCommand());
			commands.put("meteo", new WeatherCommand());
			commands.put("Meteo", new WeatherCommand());
		}
		
		public Builder withCommands(Map<String, Command> commands){
			this.commands = commands;
			return this;
		}
		
		public WikiAI build(){
			return new WikiAI(this);
		}
		
	}
	
	private WikiAI(Builder build) {
		this.commands = build.commands;
	}
	
	public String reply(String message) {
		Iterator<String> keys = commands.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			if(message.contains(key)){
				return commands.get(key).execute(message);
			}
		}
		return new InvalidCommand().execute(message);
	}
	
}
