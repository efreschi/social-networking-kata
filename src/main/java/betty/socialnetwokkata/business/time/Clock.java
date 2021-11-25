package betty.socialnetwokkata.business.time;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Clock {

    public LocalDateTime nowDateTime(){
        return LocalDateTime.now();
    }
}
