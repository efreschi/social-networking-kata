package betty.socialnetwokkata.print;

import java.util.List;

import betty.socialnetwokkata.business.model.MessageModel;

public class PrintMessageConsole {
	
	private Console console;

	public PrintMessageConsole(Console console) {
		super();
		this.console = console;
	}

	public void print(List<MessageModel> messages) {
		messages.forEach(m -> console.println(format(m)));
	}
	
	protected String format(MessageModel message) {
		return String.format("%s", message.getMessage());
	}
}
