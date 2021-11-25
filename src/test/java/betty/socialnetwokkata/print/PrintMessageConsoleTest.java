package betty.socialnetwokkata.print;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import betty.socialnetwokkata.business.entity.Message;
import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.support.MessageModelBuilder;

public class PrintMessageConsoleTest {
	
	@Test
	public void testPrintMessage() {
		FormatDateTime formatter = mock(FormatDateTime.class);
		Console c = mock(Console.class);
		PrintMessageConsole p = new PrintMessageConsole(c, formatter);
		Message message = Message.builder().username("Alice").message("Messaggio Alice").build();
		LocalDateTime dt = LocalDateTime.of(2021, 11, 21, 23, 45, 11);
		message.setTime(dt);
		when(formatter.format(dt)).thenReturn("(2 minutes ago)");
		
		p.print(Arrays.asList(message));
		
		verify(c).println(message.getMessage() + " (2 minutes ago)");
	}

	@Test
	public void testPrintMessages() {
		FormatDateTime formatter = mock(FormatDateTime.class);
		Console c = mock(Console.class);
		PrintMessageConsole p = new PrintMessageConsole(c, formatter);
		Message message1 = Message.builder().username("Alice").message("Messaggio 1").build();
		LocalDateTime dt = LocalDateTime.of(2021, 11, 21, 23, 45, 11);
		message1.setTime(dt);
		when(formatter.format(dt)).thenReturn("(15 minutes ago)");
		Message message2 = Message.builder().username("Alice").message("Messaggio 2").build();
		dt = LocalDateTime.of(2021, 11, 21, 23, 58, 11);
		message2.setTime(dt);
		when(formatter.format(dt)).thenReturn("(2 minutes ago)");
		p.print(Arrays.asList(message2, message1));
		
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		verify(c, times(2)).println(argument.capture());
		
		List<String> values = argument.getAllValues();
		
		assertThat(values).isEqualTo(Arrays.asList("Messaggio 2 (2 minutes ago)", "Messaggio 1 (15 minutes ago)"));
	}
}
