package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Locked extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String lostStatus;
    private String imeiStatus;
    private String lockStatus;
    private Long phoneId;

    public Locked(LostPhone aggregate) {
        super(aggregate);
    }

    public Locked() {
        super();
    }
}
//>>> DDD / Domain Event
