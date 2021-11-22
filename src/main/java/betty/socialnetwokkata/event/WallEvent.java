package betty.socialnetwokkata.event;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.MessageQueryService;
import betty.socialnetwokkata.print.PrintUserMessageConsole;

public class WallEvent implements SocialNetworkKataEvent {

	private MessageQueryService service;
	private PrintUserMessageConsole printMessageConsole;
	
	public WallEvent(MessageQueryService service, PrintUserMessageConsole printMessageConsole) {
		super();
		this.service = service;
		this.printMessageConsole = printMessageConsole;
	}


	protected void eseguiEvento(String username) {
		printMessageConsole.print(service.wall(new UserModel().setUsername(username)));
	}

	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username);
	}
}
