package betty.socialnetwokkata.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.print.Console;

@Component
public class ConsoleInputReader implements ItemReader<String> {

	@Autowired
	private Console console;

	public ConsoleInputReader(Console console) {
		super();
		this.console = console;
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return console.readLine();
	}

}
