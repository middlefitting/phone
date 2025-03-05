package untitled.domain;

import java.util.Date;
import lombok.Data;

@Data
public class StationInfoListQuery {

    private Long id;
    private String name;
    private Date date;
    private String x;
    private String y;
}
