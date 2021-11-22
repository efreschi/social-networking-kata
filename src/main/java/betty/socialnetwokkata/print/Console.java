package betty.socialnetwokkata.print;

import java.util.Scanner;

public class Console {

	private Scanner scanner;


	public Console(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public void println(String s) {
		System.out.println(s);
	}
	
	public String readLine() {
		return scanner.nextLine();
	}
}
