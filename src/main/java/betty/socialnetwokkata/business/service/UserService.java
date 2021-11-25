package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.repository.FollowerRepository;

@Service
public class UserService {
	
	@Autowired
	private FollowerRepository followerRepo;

	public UserService(FollowerRepository followerRepo) {
		super();
		this.followerRepo = followerRepo;
	}

	public void follow(UserModel follower, UserModel user) {
		followerRepo.addFollower(follower, user);
	}
}
