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

import betty.socialnetwokkata.business.model.MessageModel;
import betty.socialnetwokkata.business.support.MessageModelBuilder;
import betty.socialnetwokkata.print.Console;
import betty.socialnetwokkata.print.FormatDateTime;
import betty.socialnetwokkata.print.PrintUserMessageConsole;

public class PrintUserMessageConsoleTest {
	
	@Test
	public void testPrintMessage() {
		FormatDateTime formatter = mock(FormatDateTime.class);
		Console c = mock(Console.class);
		PrintUserMessageConsole p = new PrintUserMessageConsole(c, formatter);
		MessageModel message = MessageModelBuilder.buildMessage("Alice", "Messaggio");
		LocalDateTime dt = LocalDateTime.of(2021, 11, 21, 23, 45, 11);
		message.setTime(dt);
		when(formatter.format(dt)).thenReturn("(2 minutes ago)");
		
		p.print(Arrays.asList(message));
		
		verify(c).println(message.getUser().getUsername() + " - " +  message.getMessage() + " (2 minutes ago)");
	}

	@Test
	public void testPrintMessages() {
		FormatDateTime formatter = mock(FormatDateTime.class);
		Console c = mock(Console.class);
		PrintUserMessageConsole p = new PrintUserMessageConsole(c, formatter);
		MessageModel message1 = MessageModelBuilder.buildMessage("Alice", "Messaggio 1");
		LocalDateTime dt = LocalDateTime.of(2021, 11, 21, 23, 45, 11);
		message1.setTime(dt);
		when(formatter.format(dt)).thenReturn("(2 minutes ago)");
		MessageModel message2 = MessageModelBuilder.buildMessage("Alice", "Messaggio 2");
		dt = LocalDateTime.of(2021, 11, 21, 23, 50, 11);
		message2.setTime(dt);
		when(formatter.format(dt)).thenReturn("(7 minutes ago)");

		p.print(Arrays.asList(message1, message2));
		
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		verify(c, times(2)).println(argument.capture());
		
		List<String> values = argument.getAllValues();
		String s1 = message1.getUser().getUsername() + " - " +  message1.getMessage() + " (2 minutes ago)";
		String s2 = message2.getUser().getUsername() + " - " +  message2.getMessage() + " (7 minutes ago)";
		
		assertThat(values).isEqualTo(Arrays.asList(s1, s2));
	}
}
