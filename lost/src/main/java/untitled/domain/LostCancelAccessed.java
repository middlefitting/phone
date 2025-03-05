package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostCancelAccessed extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String lostStatus;
    private String imeiStatus;
    private String lockStatus;
    private Long phoneId;

    public LostCancelAccessed(LostPhone aggregate) {
        super(aggregate);
    }

    public LostCancelAccessed() {
        super();
    }
}
//>>> DDD / Domain Event
