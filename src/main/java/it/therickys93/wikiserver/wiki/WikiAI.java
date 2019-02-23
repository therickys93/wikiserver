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
			commands.put("data", new DateCommand());
			commands.put("ore", new TimeCommand());
			commands.put("ora", new TimeCommand());
			commands.put("grazie", new ThankYouCommand());
			commands.put("conferma comando", new ConfirmCommand());
			commands.put("cerca", new WikipediaSearchCommand());
			commands.put("calcola", new CalculatorCommand());
			commands.put("Calcola", new CalculatorCommand());
			commands.put("meteo", new WeatherCommand());
			commands.put("db", new DBStatusCommand());
			commands.put("aggiungi", new AddCommand());
			commands.put("rimuovi", new RemoveCommand());
			commands.put("accendi", new SwitchOnCommand());
			commands.put("spegni", new SwitchOffCommand());
			commands.put("come stai", new HowAreYouCommand());
			commands.put("come ti chiami", new WhatIsYourNameCommand());
			commands.put("connessioni", new ConnectionsCommand());
			commands.put("collegamenti", new ConnectionsCommand());
			commands.put("sensori", new GetSensorsCommand());
			commands.put("sensore", new SensorsCommand());
			commands.put("stato", new StatusCommand());
			commands.put("apri", new OpenCloseCommand());
			commands.put("chiudi", new OpenCloseCommand());
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
	
	public String reply(String message, String user_id) {
		Iterator<String> keys = commands.keySet().iterator();
		while(keys.hasNext()){
			String key = keys.next();
			if(message.contains(key)){
				return commands.get(key).execute(message, user_id);
			}
		}
		return new InvalidCommand().execute(message, user_id);
	}
	
}
