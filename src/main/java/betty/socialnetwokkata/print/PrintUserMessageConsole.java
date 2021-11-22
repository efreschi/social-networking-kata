package betty.socialnetwokkata.print;

import java.util.List;

import betty.socialnetwokkata.business.model.MessageModel;

public class PrintUserMessageConsole {
	
	private Console console;
	private FormatDateTime formatter;

	public PrintUserMessageConsole(Console console, FormatDateTime formatter) {
		super();
		this.console = console;
		this.formatter = formatter;
	}

	public void print(List<MessageModel> messages) {
		messages.forEach(m -> console.println(format(m)));
	}
	
	protected String format(MessageModel message) {
		return String.format("%s - %s %s", 
				message.getUser().getUsername(), 
				message.getMessage(), 
				formatter.format(message.getTime()));
	}
}
