package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.command.FollowsCommand;
import betty.socialnetwokkata.event.SocialNetworkKataEvent;

@Service("FollowsCommand")
public class FollowsService implements SocialNetworkingKataService<FollowsCommand>, SocialNetworkKataEvent {

	@Autowired
	private UserService service;
	
	public FollowsService(UserService service) {
		super();
		this.service = service;
	}


	protected void eseguiEvento(String username, String userToFollow) {
		service.follow(UserModel.builder().username(username).build(), 
				UserModel.builder().username(userToFollow).build());
	}

	@Override
	public void execute(FollowsCommand command) {
		eseguiEvento(command.getUsername(), command.getFollowed());
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username, args[0]);
	}
}
