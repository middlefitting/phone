package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneChangeCanceled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;

    public PhoneChangeCanceled(PhoneChange aggregate) {
        super(aggregate);
    }

    public PhoneChangeCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
