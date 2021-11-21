package betty.event;

import betty.business.model.UserModel;
import betty.business.service.MessageQueryService;
import betty.print.PrintMessageConsole;

public class ReadEvent implements SocialNetworkKataEvent {

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


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username);
	}
}
