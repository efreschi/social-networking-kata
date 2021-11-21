package betty.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import betty.business.model.MessageModel;
import betty.business.model.UserModel;
import betty.business.service.MessageQueryService;
import betty.business.support.MessageModelBuilder;
import betty.print.PrintMessageConsole;

public class WallEventTest {
	
	private MessageQueryService service = mock(MessageQueryService.class);
	private PrintMessageConsole printMessageConsole = mock(PrintMessageConsole.class);
	
    @AfterEach
    void clear() {
        reset(printMessageConsole, service);
    }

    @Test
	public void testReadAlice() {
		ReadEvent re = new ReadEvent(service, printMessageConsole);
		UserModel alice = new UserModel().setUsername("Alice");
		MessageModel mAlice = MessageModelBuilder.buildMessage(alice.getUsername(), "Messaggio Alice");  
		UserModel bob = new UserModel().setUsername("Bob");
		MessageModel mBob = MessageModelBuilder.buildMessage(bob.getUsername(), "Messaggio Bob");  
		UserModel charlie = new UserModel().setUsername("Charlie");
		MessageModel mCharlie = MessageModelBuilder.buildMessage(charlie.getUsername(), "Messaggio Charlie");  
		when(service.read(alice)).thenReturn(Arrays.asList(mAlice, mBob, mCharlie));
		
		re.eseguiEvento(alice.getUsername());
		
		verify(printMessageConsole).print(Arrays.asList(mAlice, mBob, mCharlie));
	}

}
