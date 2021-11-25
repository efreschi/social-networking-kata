package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Follower;
import betty.socialnetwokkata.business.model.UserModel;
import betty.socialnetwokkata.business.repository.FollowerJpaRepository;

public class UserServiceTest {

	private FollowerJpaRepository repo = mock(FollowerJpaRepository.class);
	
	@Test
	public void testCharlieFollowsAlice() {
		UserService us = new UserService(repo);
		UserModel charlie = new UserModel().setUsername("Charlie");
		UserModel alice = new UserModel().setUsername("Alice");
		us.follow(charlie.getUsername(), alice.getUsername());
		
		verify(repo).save(Follower.builder().username(alice.getUsername()).follower(charlie.getUsername()).build());
	}

}
