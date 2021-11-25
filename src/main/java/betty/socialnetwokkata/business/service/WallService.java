package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.command.WallCommand;
import betty.socialnetwokkata.event.SocialNetworkKataEvent;
import betty.socialnetwokkata.print.PrintUserMessageConsole;

@Service("WallCommand")
public class WallService implements SocialNetworkKataEvent, SocialNetworkingKataService<WallCommand> {

	@Autowired
	private MessageQueryService service;
	@Autowired
	private PrintUserMessageConsole printMessageConsole;
	
	public WallService(MessageQueryService service, PrintUserMessageConsole printMessageConsole) {
		super();
		this.service = service;
		this.printMessageConsole = printMessageConsole;
	}


	protected void eseguiEvento(String username) {
		printMessageConsole.print(service.wall(username));
	}

	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username);
	}


	@Override
	public void execute(WallCommand command) {
		eseguiEvento(command.getUsername());
	}
}
