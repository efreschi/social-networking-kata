package betty.socialnetwokkata.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.MessageQueryService;
import betty.socialnetwokkata.print.PrintUserMessageConsole;

@Component
public class WallEvent implements SocialNetworkKataEvent {

	@Autowired
	private MessageQueryService service;
	@Autowired
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
