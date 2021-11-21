package betty.print;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import betty.business.model.MessageModel;
import betty.business.support.MessageModelBuilder;

public class PrintMessageConsoleTest {
	
	private Console c = mock(Console.class);
	
    @BeforeEach
    void clear() {
        reset(c);
    }
	
	@Test
	public void testPrintMessage() {
		PrintMessageConsole p = new PrintMessageConsole(c);
		MessageModel message = MessageModelBuilder.buildMessage("Alice", "Messaggio");
		p.print(Arrays.asList(message));
		
		verify(c).println(message.getMessage());
	}

	@Test
	public void testPrintMessages() {
		PrintMessageConsole p = new PrintMessageConsole(c);
		MessageModel message1 = MessageModelBuilder.buildMessage("Alice", "Messaggio 1");
		MessageModel message2 = MessageModelBuilder.buildMessage("Alice", "Messaggio 2");
		p.print(Arrays.asList(message2, message1));
		
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		verify(c, times(2)).println(argument.capture());
		
		List<String> values = argument.getAllValues();
		
		assertThat(values).isEqualTo(Arrays.asList("Messaggio 2", "Messaggio 1"));
	}
}
