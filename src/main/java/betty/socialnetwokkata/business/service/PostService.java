package betty.socialnetwokkata.business.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.command.PostCommand;

@Service("PostCommand")
@Transactional
public class PostService implements SocialNetworkingKataService<PostCommand> {

	@Autowired
	private MessageService service;
	
	public PostService(MessageService service) {
		super();
		this.service = service;
	}


	protected void eseguiEvento(String username, String message) {
		service.post(Message.builder().username(username).message(message).build());
	}

	@Override
	public void execute(PostCommand command) {
		eseguiEvento(command.getUsername(), command.getMessage());
	}
}
