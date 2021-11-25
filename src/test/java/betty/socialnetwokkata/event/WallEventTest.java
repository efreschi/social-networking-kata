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
import betty.socialnetwokkata.business.support.UserModel;
import betty.socialnetwokkata.print.PrintMessageConsole;

public class WallEventTest {
	
	private MessageQueryService service = mock(MessageQueryService.class);
	private PrintMessageConsole printMessageConsole = mock(PrintMessageConsole.class);
	
    @AfterEach
    void clear() {
        reset(printMessageConsole, service);
    }

    @Test
	public void testReadAlice() {
		ReadService re = new ReadService(service, printMessageConsole);
		UserModel alice = new UserModel().setUsername("Alice");
		Message message = Message.builder().username(alice.getUsername()).message("Messaggio Alice").build();
		UserModel bob = new UserModel().setUsername("Bob");
		Message mBob = Message.builder().username(bob.getUsername()).message("Messaggio Bob").build();
		UserModel charlie = new UserModel().setUsername("Charlie");
		Message mCharlie = Message.builder().username(charlie.getUsername()).message("Messaggio Charlie").build();
		when(service.read(alice.getUsername())).thenReturn(Arrays.asList(message, mBob, mCharlie));
		
		re.eseguiEvento(alice.getUsername());
		
		verify(printMessageConsole).print(Arrays.asList(message, mBob, mCharlie));
	}

}
