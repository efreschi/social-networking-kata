package betty.socialnetwokkata.print;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Console {

	private Scanner scanner;

	public Console() {
		super();
	}

	
	public Scanner getScanner() {
		return scanner;
	}


	@Autowired
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}


	public void println(String s) {
		System.out.println(s);
	}
	
	public String readLine() {
		return Optional.of(scanner.hasNextLine()).filter(Boolean.TRUE::equals).map(t -> scanner.nextLine())
				.orElse(null);
	}
}
