package betty.event;

import betty.business.service.MessageService;
import betty.business.support.MessageModelBuilder;

public class PostEvent implements SocialNetworkKataEvent {

	private MessageService service;
	
	public PostEvent(MessageService service) {
		super();
		this.service = service;
	}


	public void eseguiEvento(String username, String message) {
		service.post(MessageModelBuilder.buildMessage(username, message));
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username, args[0]);
	}
}
