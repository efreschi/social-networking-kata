package betty.socialnetwokkata.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import betty.socialnetwokkata.event.SocialNetworkKataInvoker;
import betty.socialnetwokkata.print.Console;

public class SocialNetworkKataEngineTest {

	@Test
	public void testEngine() {
		Console console = mock(Console.class);
		SocialNetworkKataInvoker invoker = mock(SocialNetworkKataInvoker.class);
		when(console.readLine())
			.thenReturn("Alice -> I love the weather today")
			.thenReturn("Alice")
			.thenReturn("STOP");
		
		SocialNetworkKataEngine engine = new SocialNetworkKataEngine(console, invoker);
		engine.run();
		
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		verify(invoker, times(2)).invoke(argument.capture());

		List<String> values = argument.getAllValues();
		
		assertThat(values).isEqualTo(Arrays.asList("Alice -> I love the weather today", "Alice"));
	}
}
