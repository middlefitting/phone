package phone.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "GpsInfoList_table")
@Data
public class GpsInfoList {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Date time;
    private String x;
    private String y;
    private Long phoneId;
}
