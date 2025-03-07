package phone.domain;

import java.util.Date;
import lombok.Data;

@Data
public class GpsInfoListQuery {

    private Long id;
    private Date time;
    private String x;
    private String y;
}
