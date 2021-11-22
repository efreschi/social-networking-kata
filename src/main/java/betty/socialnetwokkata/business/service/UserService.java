package betty.socialnetwokkata.business.service;

import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.repository.FollowerRepository;

public class UserService {
	
	private FollowerRepository followerRepo;

	public UserService(FollowerRepository followerRepo) {
		super();
		this.followerRepo = followerRepo;
	}

	public void follow(UserModel follower, UserModel user) {
		followerRepo.addFollower(follower, user);
	}
}
