package betty.socialnetwokkata.step;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.command.FollowsCommand;
import betty.socialnetwokkata.command.PostCommand;
import betty.socialnetwokkata.command.ReadCommand;
import betty.socialnetwokkata.command.SocialNetworkingKataCommand;
import betty.socialnetwokkata.command.WallCommand;

public class SocialNetworkingKataProcessorTest {

    @Test
	public void testAliceReadIstruzioneThenReadCommand() throws Exception {
		String username = "Alice";
		String istruzione = username;
		ReadCommand command = ReadCommand.builder().username(username).build();
		
		SocialNetworkingKataProcessor processor = new SocialNetworkingKataProcessor();
		SocialNetworkingKataCommand result = processor.process(istruzione);
		
		assertThat(result).isEqualToComparingFieldByFieldRecursively(command);
	}

    @Test
	public void testAlicePostMessageIstruzioneThenPostCommand() throws Exception {
		String username = "Alice";
		String message = "Messaggio Alice";
		String istruzione = username + " -> " + message;
		PostCommand command = PostCommand.builder().username(username).message(message).build();
		
		SocialNetworkingKataProcessor processor = new SocialNetworkingKataProcessor();
		SocialNetworkingKataCommand result = processor.process(istruzione);
		
		assertThat(result).isEqualToComparingFieldByFieldRecursively(command);
	}

    @Test
	public void testAliceWallIstruzioneThenWallCommand() throws Exception {
		String username = "Alice";
		String istruzione = username + " wall";
		WallCommand command = WallCommand.builder().username(username).build();
		
		SocialNetworkingKataProcessor processor = new SocialNetworkingKataProcessor();
		SocialNetworkingKataCommand result = processor.process(istruzione);
		
		assertThat(result).isEqualToComparingFieldByFieldRecursively(command);
	}

    @Test
	public void testAliceFollowsCharlieIstruzioneThenFollowsCommand() throws Exception {
		String username = "Alice";
		String followed = "Charlie";
		String istruzione = username + " follows " + followed;
		FollowsCommand command = FollowsCommand.builder().username(username).followed(followed).build();
		
		SocialNetworkingKataProcessor processor = new SocialNetworkingKataProcessor();
		SocialNetworkingKataCommand result = processor.process(istruzione);
		
		assertThat(result).isEqualToComparingFieldByFieldRecursively(command);
	}
}
