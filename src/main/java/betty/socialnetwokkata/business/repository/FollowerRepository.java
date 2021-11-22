package betty.socialnetwokkata.business.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import betty.socialnetwokkata.business.model.UserModel;

public class FollowerRepository {
	
	private Map<UserModel, List<UserModel>> followers = 
			new HashMap<UserModel, List<UserModel>>();

	public void addFollower(UserModel follower, UserModel user) {
		List<UserModel> followed = followers.get(follower);
		if (followed == null) {
			followed = initializeFollowedForFollower(follower);
		}
		followed.add(user);
	}
	
	public List<UserModel> findUsersByFollower(UserModel follower) {
		List<UserModel> users =
				Optional.ofNullable(followers.get(follower)).orElseGet(() -> Arrays.asList(follower));
		if (!users.contains(follower)) {
			users.add(follower);
		}
		return users;
	}

	private List<UserModel> initializeFollowedForFollower(UserModel follower) {
		List<UserModel> followed;
		synchronized (followers) {
			followed = followers.get(follower);
			if (followed == null) {
				followed = new ArrayList<UserModel>();
				followers.put(follower, followed);
			}
		}
		return followed;
	}
}
