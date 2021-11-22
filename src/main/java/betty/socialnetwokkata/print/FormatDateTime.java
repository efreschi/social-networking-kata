package betty.socialnetwokkata.print;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import betty.socialnetwokkata.business.time.Clock;

public class FormatDateTime {
	
	private Clock clock;

	public FormatDateTime(Clock clock) {
		super();
		this.clock = clock;
	}

	public String format(LocalDateTime dt) {
		long sec = Duration.between(dt, clock.nowDateTime()).toSeconds();
		if (sec < 60) {
			return String.format("(%s seconds ago)", sec);
		}
		if (sec < 3600) {
			return String.format("(%s minutes ago)", TimeUnit.SECONDS.toMinutes(sec));
		}
		if (sec < 24 * 3600) {
			return String.format("(%s hours ago)", TimeUnit.SECONDS.toHours(sec));
		}
		return String.format("(%s days ago)", TimeUnit.SECONDS.toDays(sec));
	}
}
