package betty.socialnetwokkata.step;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.print.Console;

public class ConsoleInputReaderTest {

	@Test
	public void testReadingFromConsole() throws Exception {
		Console console = mock(Console.class);
		String i1 = "Alice -> I love the weather today";
		String i2 = "Alice";
		String i3 = "STOP";
		when(console.readLine())
			.thenReturn(i1)
			.thenReturn(i2)
			.thenReturn(i3);
		ConsoleInputReader reader = new ConsoleInputReader(console);
		assertThat(reader.read()).isEqualTo(i1);
		assertThat(reader.read()).isEqualTo(i2);
		assertThat(reader.read()).isEqualTo(i3);
	}
}
