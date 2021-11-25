package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.command.ReadCommand;
import betty.socialnetwokkata.command.WallCommand;
import betty.socialnetwokkata.print.PrintMessageConsole;
import betty.socialnetwokkata.print.PrintUserMessageConsole;

public class WallServiceTest {

	@Test
	public void testAliceRead() {
		MessageQueryService messageService = mock(MessageQueryService.class);
		PrintUserMessageConsole printMessageConsole = mock(PrintUserMessageConsole.class);
		WallService service = new WallService(messageService, printMessageConsole);
		
		String username = "Alice";	
		String message = "Messaggio Alice";
		Message m = Message.builder().username(username).message(message).build();
		String bob = "Bob";	
		String bobmessage = "Messaggio Bob";
		Message mBob = Message.builder().username(bob).message(bobmessage).build();
		String charlie = "Charlie";	
		String charlieMessage = "Messaggio Charlie";
		Message mCharlie = Message.builder().username(charlie).message(charlieMessage).build();

		when(messageService.wall(username)).thenReturn(Arrays.asList(m, mBob, mCharlie));
		WallCommand command = 
				WallCommand.builder().username(username).build();
		service.execute(command);
		
		verify(messageService).wall(username);
		verify(printMessageConsole).print(Arrays.asList(m, mBob, mCharlie));
	}
}
