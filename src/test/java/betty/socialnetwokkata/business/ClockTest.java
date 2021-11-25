package betty.socialnetwokkata.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import betty.socialnetwokkata.business.time.Clock;

public class ClockTest {

	@Test
	public void testClockNowTimeIsNow() {
		Clock clock = new Clock();
		assertThat(Duration.between(clock.nowDateTime(), LocalDateTime.now())).isLessThan(Duration.ofSeconds(1L));
	}
}
