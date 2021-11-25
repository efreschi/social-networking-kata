package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.support.MessageModelBuilder;
import betty.socialnetwokkata.command.PostCommand;
import betty.socialnetwokkata.event.SocialNetworkKataEvent;

@Service("PostCommand")
public class PostService implements SocialNetworkKataEvent, SocialNetworkingKataService<PostCommand> {

	@Autowired
	private MessageService service;
	
	public PostService(MessageService service) {
		super();
		this.service = service;
	}


	protected void eseguiEvento(String username, String message) {
		service.post(MessageModelBuilder.buildMessage(username, message));
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username, args[0]);
	}


	@Override
	public void execute(PostCommand command) {
		eseguiEvento(command.getUsername(), command.getMessage());
	}
}
