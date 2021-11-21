package betty.event;

import betty.business.model.UserModel;
import betty.business.service.MessageQueryService;
import betty.print.PrintUserMessageConsole;

public class WallEvent {

	private MessageQueryService service;
	private PrintUserMessageConsole printMessageConsole;
	
	public WallEvent(MessageQueryService service, PrintUserMessageConsole printMessageConsole) {
		super();
		this.service = service;
		this.printMessageConsole = printMessageConsole;
	}


	public void eseguiEvento(String username) {
		printMessageConsole.print(service.wall(new UserModel().setUsername(username)));
	}
}
