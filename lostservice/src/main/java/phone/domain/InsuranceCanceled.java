package phone.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InsuranceCanceled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long lostPhoneId;
    private String status;

    public InsuranceCanceled(Insurance aggregate) {
        super(aggregate);
    }

    public InsuranceCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
