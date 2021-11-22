package betty.socialnetwokkata.print;

import betty.socialnetwokkata.business.model.MessageModel;

public class PrintUserMessageConsole extends PrintMessageConsole {
	
	public PrintUserMessageConsole(Console console, FormatDateTime formatter) {
		super(console, formatter);
	}
	
	protected String format(MessageModel message) {
		return String.format("%s - %s %s", 
				message.getUser().getUsername(), 
				message.getMessage(), 
				getFormatter().format(message.getTime()));
	}
}
