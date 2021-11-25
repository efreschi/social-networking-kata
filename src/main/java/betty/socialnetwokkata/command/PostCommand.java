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
public class PostCommand implements SocialNetworkingKataCommand {

	private String username;
	private String message;


	@Override
	public void populate(String username, String... args) {
		setUsername(username);
		setMessage(args[0]);
	}
}
