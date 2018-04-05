package it.therickys93.wikiserver.wiki;

import java.math.BigDecimal;
import com.github.bgora.rpnlibrary.CalculatorInterface;
import com.github.bgora.rpnlibrary.advanced.AdvancedCalculatorFactory;

import it.therickys93.wikiserver.utils.CommandParser;

public class CalculatorCommand implements Command {

	@Override
	public String execute(String request) {
		
		CommandParser parser = new CommandParser(request);
		
		try {
			AdvancedCalculatorFactory advancedCalculatorFactory = new AdvancedCalculatorFactory();
			CalculatorInterface calc = advancedCalculatorFactory.createCalculator();
			BigDecimal result = calc.calculate(parser.getArgument());
			return "il risultato è " + result.toString();
	
		} catch (Exception e){
			// e.getMessage()
		}
		return "Errore nel calcolo";
	}

}
