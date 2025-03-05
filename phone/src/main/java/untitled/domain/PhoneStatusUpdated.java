package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PhoneStatusUpdated extends AbstractEvent {

    private Long id;
    private Long userId;
    private String status;
    private String imei;

    public PhoneStatusUpdated(Phone aggregate) {
        super(aggregate);
    }

    public PhoneStatusUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
