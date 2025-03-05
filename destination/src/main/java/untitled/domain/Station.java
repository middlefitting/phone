package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.DestinationApplication;
import untitled.domain.StationChanged;

@Entity
@Table(name = "Station_table")
@Data
//<<< DDD / Aggregate Root
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date date;

    private String x;

    private String y;

    public static StationRepository repository() {
        StationRepository stationRepository = DestinationApplication.applicationContext.getBean(
            StationRepository.class
        );
        return stationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void stationChange(LogTransfered logTransfered) {
        //implement business logic here:

        /** Example 1:  new item 
        Station station = new Station();
        repository().save(station);

        StationChanged stationChanged = new StationChanged(station);
        stationChanged.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(logTransfered.get???()).ifPresent(station->{
            
            station // do something
            repository().save(station);

            StationChanged stationChanged = new StationChanged(station);
            stationChanged.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
