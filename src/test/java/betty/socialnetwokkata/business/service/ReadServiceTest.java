package betty.socialnetwokkata.business.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.command.ReadCommand;
import betty.socialnetwokkata.print.PrintMessageConsole;

public class ReadServiceTest {

	@Test
	public void testAliceRead() {
		MessageQueryService messageService = mock(MessageQueryService.class);
		PrintMessageConsole printMessageConsole = mock(PrintMessageConsole.class);
		ReadService service = new ReadService(messageService, printMessageConsole);
		
		String username = "Alice";
		String message = "Messaggio Alice";
		Message m = Message.builder().username(username).message(message).build();
		when(messageService.read(username)).thenReturn(Arrays.asList(m));
		ReadCommand command = 
				ReadCommand.builder().username(username).build();
		service.execute(command);
		
		verify(messageService).read(username);
		verify(printMessageConsole).print(Arrays.asList(m));
	}
}
