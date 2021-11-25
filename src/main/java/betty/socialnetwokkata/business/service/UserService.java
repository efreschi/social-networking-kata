package betty.socialnetwokkata.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import betty.socialnetwokkata.business.entity.Follower;
import betty.socialnetwokkata.business.repository.FollowerJpaRepository;

@Service
public class UserService {
	
	@Autowired
	private FollowerJpaRepository followerRepo;

	public UserService(FollowerJpaRepository followerRepo) {
		super();
		this.followerRepo = followerRepo;
	}

	public void follow(String follower, String user) {
		followerRepo.save(Follower.builder().follower(follower).username(user).build());
	}
}
