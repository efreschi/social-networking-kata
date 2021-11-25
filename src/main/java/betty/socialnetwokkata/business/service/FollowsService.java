package betty.socialnetwokkata.business.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.command.FollowsCommand;
import betty.socialnetwokkata.event.SocialNetworkKataEvent;

@Service("FollowsCommand")
@Transactional
public class FollowsService implements SocialNetworkingKataService<FollowsCommand>, SocialNetworkKataEvent {

	@Autowired
	private UserService service;
	
	public FollowsService(UserService service) {
		super();
		this.service = service;
	}


	protected void eseguiEvento(String username, String userToFollow) {
		service.follow(username, 
				userToFollow);
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
