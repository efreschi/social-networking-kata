package betty.event;

import betty.business.model.UserModel;
import betty.business.service.MessageService;
import betty.business.service.UserService;
import betty.business.support.MessageModelBuilder;

public class FollowsEvent implements SocialNetworkKataEvent {

	private UserService service;
	
	public FollowsEvent(UserService service) {
		super();
		this.service = service;
	}


	public void eseguiEvento(String username, String userToFollow) {
		service.follow(UserModel.builder().username(username).build(), 
				UserModel.builder().username(userToFollow).build());
	}


	@Override
	public void eseguiEvento(String username, String... args) {
		eseguiEvento(username, args[0]);
	}
}
