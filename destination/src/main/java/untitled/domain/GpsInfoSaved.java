package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class GpsInfoSaved extends AbstractEvent {

    private Long id;
    private Date time;
    private String x;
    private String y;

    public GpsInfoSaved(Destination aggregate) {
        super(aggregate);
    }

    public GpsInfoSaved() {
        super();
    }
}
//>>> DDD / Domain Event
