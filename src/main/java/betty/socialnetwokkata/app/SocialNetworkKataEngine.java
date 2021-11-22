package betty.socialnetwokkata.app;

import betty.socialnetwokkata.event.SocialNetworkKataInvoker;
import betty.socialnetwokkata.print.Console;

public class SocialNetworkKataEngine {
	
	private Console console;
	private SocialNetworkKataInvoker invoker;

	public SocialNetworkKataEngine(Console console, SocialNetworkKataInvoker invoker) {
		super();
		this.console = console;
		this.invoker = invoker;
	}

	public void run() {
		console.println("L'applicazione risulta avviata correttamente. Adesso puoi scrivere sulla console. Quando vuoi terminare l'applicazione scrivi STOP (e invio)");
		String  istruzione = console.readLine();
		while (!"STOP".equals(istruzione)) {
			invoker.invoke(istruzione);
			istruzione = console.readLine();
		}
		console.println("Applicazione terminata come previsto");		
	}
}
