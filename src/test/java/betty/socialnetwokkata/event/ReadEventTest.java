package betty.socialnetwokkata.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.service.MessageQueryService;
import betty.socialnetwokkata.business.service.ReadService;
import betty.socialnetwokkata.print.PrintMessageConsole;

public class ReadEventTest {
	
	private MessageQueryService service = mock(MessageQueryService.class);
	private PrintMessageConsole printMessageConsole = mock(PrintMessageConsole.class);
	
    @AfterEach
    void clear() {
        reset(printMessageConsole, service);
    }

    @Test
	public void testReadAlice() {
		ReadService re = new ReadService(service, printMessageConsole);
		Message message = Message.builder().username("Alice").message("Messaggio Alice").build();
		when(service.read(message.getUsername())).thenReturn(Arrays.asList(message));
		
		re.eseguiEvento(message.getUsername());
		
		verify(printMessageConsole).print(Arrays.asList(message));
	}

}
