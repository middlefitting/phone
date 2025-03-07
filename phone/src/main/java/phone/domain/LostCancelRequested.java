package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class LostCancelRequested extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imei;
    private Long phoneId;
    private Boolean cancel;
}
