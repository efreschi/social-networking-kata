package betty.socialnetwokkata.command;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(chain = true)
@NoArgsConstructor()
public class FollowsCommand implements SocialNetworkingKataCommand {

	private String username;
	private String followed;

	@Override
	public void populate(String username, String... args) {
		setUsername(username);
		setFollowed(args[0]);
	}
}