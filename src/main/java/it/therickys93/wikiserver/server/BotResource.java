package it.therickys93.wikiserver.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Update;

import it.therickys93.wikiserver.utils.Configurations;
import it.therickys93.wikiserver.wiki.CalculatorCommand;
import it.therickys93.wikiserver.wiki.Command;
import it.therickys93.wikiserver.wiki.HelloCommand;
import it.therickys93.wikiserver.wiki.WeatherCommand;
import it.therickys93.wikiserver.wiki.WikiAI;
import it.therickys93.wikiserver.wiki.WikipediaSearchCommand;

public class BotResource extends ServerResource {
	
	public static final String PARSE_ERROR = "Impossible to parse the Telegram update!!!";
	public static final String GET_RESPONSE = "See the chat on Telegram for more details!!!";
	public static final boolean UPGRADE = false;
	public static final String WRONG_TELEGRAM_TOKEN = "Wrong token from Telegram servers!!!";
	public static final String WRONG_TELEGRAM_IP = "The request does not come from Telegram!!!";
	
	@Post
	public Map<String, Object> update(Representation data) throws IOException {
		
		final String token = getAttribute("token");
		if(!Configurations.telegramServerToken().equals(token)) {
			getLogger().warning(WRONG_TELEGRAM_TOKEN);
			setStatus(Status.CLIENT_ERROR_FORBIDDEN, WRONG_TELEGRAM_TOKEN);
			return null;
		}
		
		final Update update = BotUtils.parseUpdate(data.getText());
		if(update.updateId() == null) {
			getLogger().warning(PARSE_ERROR);
			setStatus(Status.CLIENT_ERROR_BAD_REQUEST, PARSE_ERROR);
			return null;
		}
				
		String message = update.message().text();
		getLogger().info(message);
		
		Chat chat = update.message().chat();
		
		String answer = "";
		if(UPGRADE) {
			answer = "Stiamo facendo manutenzione.\nRiprova piu' tardi!\n"
					+ "Per controllare lo stato dei nostri servizi clicca sul link: \n"
					+ "www.itjustworks.it/status/";
		} else {
			answer = new WikiAI.Builder().withCommands(telegramCommands()).build().reply(message, null);
		}
		getLogger().info(answer);
				
		Map<String, Object> output = new HashMap<>();
		output.put("method", "sendMessage");
		output.put("chat_id", chat.id());
		output.put("text", answer);
		
		return output;
	}
	
	@Get
	public String hello(){
		if(UPGRADE){
			setStatus(Status.SERVER_ERROR_SERVICE_UNAVAILABLE);
			return null;
		}
		getLogger().warning(GET_RESPONSE);
		setStatus(Status.CLIENT_ERROR_BAD_REQUEST, GET_RESPONSE);
		return null;
	}
	
	private Map<String, Command> telegramCommands() {
		Map<String, Command> commands = new HashMap<String, Command>();
		commands.put("/start", new HelloCommand());
		commands.put("/ciao", new HelloCommand());
		commands.put("/cerca", new WikipediaSearchCommand());
		commands.put("/calcola", new CalculatorCommand());
		commands.put("/meteo", new WeatherCommand());
		return commands;
	}
}
