package phone.domain;

import java.util.*;
import lombok.*;
import phone.domain.*;
import phone.infra.AbstractEvent;

@Data
@ToString
public class ImeiLocked extends AbstractEvent {

    private Long id;
    private Long userId;
    private String imeiStatus;
    private Long phoneId;
}
