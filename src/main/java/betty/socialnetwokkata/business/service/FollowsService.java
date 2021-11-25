package betty.socialnetwokkata.business.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.command.FollowsCommand;

@Service("FollowsCommand")
@Transactional
public class FollowsService implements SocialNetworkingKataService<FollowsCommand> {

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
}
