package betty.socialnetwokkata.event;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.service.MessageService;
import betty.socialnetwokkata.business.service.UserService;
import betty.socialnetwokkata.business.support.MessageModelBuilder;

public class FollowsEvent implements SocialNetworkKataEvent {

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
