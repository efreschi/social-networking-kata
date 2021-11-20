package betty.print;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import betty.business.time.Clock;

public class FormatDateTimeTest {

	private Clock clock = mock(Clock.class);
	
	
	@Test
	public void testPrint2Seconds() {
		FormatDateTime formatter = new FormatDateTime(clock);
		
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 20, 02, 03, 03));
		
		String result = formatter.format(LocalDateTime.of(2021, 11, 20, 02, 03, 01));
		assertThat(result).isEqualTo("(2 seconds ago)");
		
	}
	
	@Test
	public void testPrint35Seconds() {
		FormatDateTime formatter = new FormatDateTime(clock);
		
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 20, 02, 03, 36));
		
		String result = formatter.format(LocalDateTime.of(2021, 11, 20, 02, 03, 01));
		assertThat(result).isEqualTo("(35 seconds ago)");
		
	}

	@Test
	public void testPrint2Minutess() {
		FormatDateTime formatter = new FormatDateTime(clock);
		
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 20, 02, 05, 03));
		
		String result = formatter.format(LocalDateTime.of(2021, 11, 20, 02, 03, 01));
		assertThat(result).isEqualTo("(2 minutes ago)");
		
	}

	@Test
	public void testPrint35Minutes() {
		FormatDateTime formatter = new FormatDateTime(clock);
		
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 20, 03, 38, 36));
		
		String result = formatter.format(LocalDateTime.of(2021, 11, 20, 03, 03, 01));
		assertThat(result).isEqualTo("(35 minutes ago)");
		
	}

	@Test
	public void testPrint1Hour() {
		FormatDateTime formatter = new FormatDateTime(clock);
		
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 20, 03, 05, 03));
		
		String result = formatter.format(LocalDateTime.of(2021, 11, 20, 02, 03, 01));
		assertThat(result).isEqualTo("(1 hours ago)");
		
	}

	@Test
	public void testPrint7Hour() {
		FormatDateTime formatter = new FormatDateTime(clock);
		
		when(clock.nowDateTime()).thenReturn(LocalDateTime.of(2021, 11, 20, 21, 05, 03));
		
		String result = formatter.format(LocalDateTime.of(2021, 11, 20, 14, 03, 01));
		assertThat(result).isEqualTo("(7 hours ago)");
		
	}
}
