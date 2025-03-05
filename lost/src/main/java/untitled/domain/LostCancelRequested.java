package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostCancelRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String lostStatus;
    private String imeiStatus;
    private String lockStatus;
    private Long phoneId;

    public LostCancelRequested(LostPhone aggregate) {
        super(aggregate);
    }

    public LostCancelRequested() {
        super();
    }
}
//>>> DDD / Domain Event
