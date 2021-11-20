package betty.business.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import betty.business.model.UserModel;

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
		return followers.get(follower);
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
