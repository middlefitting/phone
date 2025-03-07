package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneChangeAccess extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;

    public PhoneChangeAccess(PhoneChange aggregate) {
        super(aggregate);
    }

    public PhoneChangeAccess() {
        super();
    }
}
//>>> DDD / Domain Event
