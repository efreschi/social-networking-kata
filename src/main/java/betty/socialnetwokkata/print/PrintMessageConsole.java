package betty.socialnetwokkata.print;

import java.util.List;

import betty.socialnetwokkata.business.model.MessageModel;

public class PrintMessageConsole {
	
	private Console console;
	private FormatDateTime formatter;

	public PrintMessageConsole(Console console, FormatDateTime formatter) {
		super();
		this.console = console;
		this.formatter = formatter;
	}

	public void print(List<MessageModel> messages) {
		messages.forEach(m -> console.println(format(m)));
	}
	
	protected String format(MessageModel message) {
		return String.format("%s %s", 
				message.getMessage(), 
				formatter.format(message.getTime()));
	}
	
	protected FormatDateTime getFormatter() {
		return formatter;
	}
}
