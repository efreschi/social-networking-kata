package betty.socialnetwokkata.command;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor()
public class PostCommand implements SocialNetworkingKataCommand {

	private String username;
	private String message;


	@Override
	public void populate(String username, String... args) {
		setUsername(username);
		setMessage(args[0]);
	}
}
