package betty.socialnetwokkata.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.UserService;

@Component
public class FollowsEvent implements SocialNetworkKataEvent {

	@Autowired
	private UserService service;
	
	public FollowsEvent(UserService service) {
		super();
		this.service = service;
	}


	protected void eseguiEvento(String username, String userToFollow) {
		service.follow(UserModel.builder().username(username).build(), 
				UserModel.builder().username(userToFollow).build());
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username, args[0]);
	}
}
