package betty.socialnetwokkata.step;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.service.FollowsService;
import betty.socialnetwokkata.business.service.PostService;
import betty.socialnetwokkata.business.service.ReadService;
import betty.socialnetwokkata.business.service.SocialNetworkingKataService;
import betty.socialnetwokkata.business.service.SocialNetworkingKataServiceFactory;
import betty.socialnetwokkata.business.service.WallService;
import betty.socialnetwokkata.command.FollowsCommand;
import betty.socialnetwokkata.command.PostCommand;
import betty.socialnetwokkata.command.ReadCommand;
import betty.socialnetwokkata.command.SocialNetworkingKataCommand;
import betty.socialnetwokkata.command.WallCommand;

public class SocialNetworkingKataWriterTest {
	
    @Test
	public void testAliceReadIstruzione() throws Exception{
		String username = "Alice";
		ReadCommand command = ReadCommand.builder().username(username).build();

		SocialNetworkingKataServiceFactory factory = mock(SocialNetworkingKataServiceFactory.class);
		ReadService service = mock(ReadService.class);
		Object res = service;
		when(factory.getSocialNetworkingKataService("ReadCommand")).thenReturn((SocialNetworkingKataService<SocialNetworkingKataCommand>)res);
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(factory);
		ki.write(Arrays.asList(command));
		
		verify(service).execute(command);
	}

    @Test
	public void testAlicePostMessageIstruzione() throws Exception {
		String username = "Alice";
		String message = "Messaggio Alice";
		PostCommand command = PostCommand.builder().username(username).message(message).build();

		SocialNetworkingKataServiceFactory factory = mock(SocialNetworkingKataServiceFactory.class);
		PostService service = mock(PostService.class);
		Object res = service;
		when(factory.getSocialNetworkingKataService("PostCommand")).thenReturn((SocialNetworkingKataService<SocialNetworkingKataCommand>)res);
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(factory);
		ki.write(Arrays.asList(command));
		
		verify(service).execute(command);
	}

    @Test
	public void testAliceWallIstruzione() throws Exception {
		String username = "Alice";
		WallCommand command = WallCommand.builder().username(username).build();

		SocialNetworkingKataServiceFactory factory = mock(SocialNetworkingKataServiceFactory.class);
		WallService service = mock(WallService.class);
		Object res = service;
		when(factory.getSocialNetworkingKataService("WallCommand")).thenReturn((SocialNetworkingKataService<SocialNetworkingKataCommand>)res);
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(factory);
		ki.write(Arrays.asList(command));
		
		verify(service).execute(command);
	}

    @Test
	public void testAliceFollowsCharlieIstruzione() throws Exception {
		String username = "Alice";
		String followed = "Charlie";
		
		FollowsCommand command = FollowsCommand.builder().username(username).followed(followed).build();

		SocialNetworkingKataServiceFactory factory = mock(SocialNetworkingKataServiceFactory.class);
		FollowsService service = mock(FollowsService.class);
		Object res = service;
		when(factory.getSocialNetworkingKataService("FollowsCommand")).thenReturn((SocialNetworkingKataService<SocialNetworkingKataCommand>)res);
		
		SocialNetworkingKataWriter ki = new SocialNetworkingKataWriter(factory);
		ki.write(Arrays.asList(command));
		
		verify(service).execute(command);
	}
}
