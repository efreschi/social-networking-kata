package betty.socialnetwokkata.print;

import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.entity.Message;

@Component
public class PrintUserMessageConsole extends PrintMessageConsole {
	
	public PrintUserMessageConsole(Console console, FormatDateTime formatter) {
		super(console, formatter);
	}
	
	protected String format(Message message) {
		return String.format("%s - %s %s", 
				message.getUsername(), 
				message.getMessage(), 
				getFormatter().format(message.getTime()));
	}
}
