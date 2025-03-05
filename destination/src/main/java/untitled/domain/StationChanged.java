package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class StationChanged extends AbstractEvent {

    private Long id;
    private String name;
    private Date date;
    private String x;
    private String y;

    public StationChanged(Station aggregate) {
        super(aggregate);
    }

    public StationChanged() {
        super();
    }
}
//>>> DDD / Domain Event
