package betty.socialnetwokkata.business.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.model.UserModel;

public class FollowerRepositoryTest {
	
	@Test
	public void testCharlieFollowerDiAliceAndBob() {
		FollowerRepository repo = new FollowerRepository();
		UserModel charlie = new UserModel()
				.setUsername("Charlie");
		List<UserModel> seguiti = repo.findUsersByFollower(charlie);
		assertThat(seguiti).isEqualTo(Arrays.asList(charlie));
		
		UserModel alice = new UserModel()
				.setUsername("Alice");	
		
		repo.addFollower(charlie, alice);
		seguiti = repo.findUsersByFollower(charlie);
		
		assertThat(seguiti).isEqualTo(Arrays.asList(alice, charlie));
		
		UserModel bob = new UserModel()
				.setUsername("Bob");	
		
		repo.addFollower(charlie, bob);
		seguiti = repo.findUsersByFollower(charlie);
		
		assertThat(seguiti).isEqualTo(Arrays.asList(alice, charlie, bob));
	}

}
