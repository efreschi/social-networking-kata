package betty.event;

import betty.business.model.UserModel;
import betty.business.service.MessageQueryService;
import betty.print.PrintMessageConsole;

public class ReadEvent {

	private MessageQueryService service;
	private PrintMessageConsole printMessageConsole;
	
	public ReadEvent(MessageQueryService service, PrintMessageConsole printMessageConsole) {
		super();
		this.service = service;
		this.printMessageConsole = printMessageConsole;
	}


	public void eseguiEvento(String username) {
		printMessageConsole.print(service.read(new UserModel().setUsername(username)));
	}
}
