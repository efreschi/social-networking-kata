package betty.business.service;

import betty.business.model.UserModel;
import betty.business.repository.FollowerRepository;

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
