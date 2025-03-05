package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneChangeAccessed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;

    public PhoneChangeAccessed(PhoneChange aggregate) {
        super(aggregate);
    }

    public PhoneChangeAccessed() {
        super();
    }
}
//>>> DDD / Domain Event
