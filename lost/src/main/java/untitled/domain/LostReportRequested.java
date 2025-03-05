package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LostReportRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private String lostStatus;
    private String imeiStatus;
    private String lockStatus;
    private Long phoneId;

    public LostReportRequested(LostPhone aggregate) {
        super(aggregate);
    }

    public LostReportRequested() {
        super();
    }
}
//>>> DDD / Domain Event
