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
@NoArgsConstructor()
public class WallCommand implements SocialNetworkingKataCommand {

	private String username;

	@Override
	public void populate(String username, String... args) {
		setUsername(username);
	}
}
