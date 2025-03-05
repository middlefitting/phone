package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class LogTransfered extends AbstractEvent {

    private Long id;
    private Long userId;
    private String status;
    private String imei;
}
