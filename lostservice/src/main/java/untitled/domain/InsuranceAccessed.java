package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InsuranceAccessed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;

    public InsuranceAccessed(Insurance aggregate) {
        super(aggregate);
    }

    public InsuranceAccessed() {
        super();
    }
}
//>>> DDD / Domain Event
