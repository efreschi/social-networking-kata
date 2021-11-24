package betty.socialnetwokkata.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import betty.socialnetwokkata.print.Console;

public class ConsoleInputReader implements ItemReader<String> {

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
