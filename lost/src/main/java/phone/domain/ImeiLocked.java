package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ImeiLocked extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String lostStatus;
    private String imeiStatus;
    private String lockStatus;
    private Long phoneId;

    public ImeiLocked(LostPhone aggregate) {
        super(aggregate);
    }

    public ImeiLocked() {
        super();
    }
}
//>>> DDD / Domain Event
