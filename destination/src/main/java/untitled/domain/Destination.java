package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.DestinationApplication;
import untitled.domain.GpsInfoSaved;

@Entity
@Table(name = "Destination_table")
@Data
//<<< DDD / Aggregate Root
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date time;

    private String x;

    private String y;

    public static DestinationRepository repository() {
        DestinationRepository destinationRepository = DestinationApplication.applicationContext.getBean(
            DestinationRepository.class
        );
        return destinationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void sendGpsInfo(LogTransfered logTransfered) {
        //implement business logic here:

        /** Example 1:  new item 
        Destination destination = new Destination();
        repository().save(destination);

        GpsInfoSaved gpsInfoSaved = new GpsInfoSaved(destination);
        gpsInfoSaved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(logTransfered.get???()).ifPresent(destination->{
            
            destination // do something
            repository().save(destination);

            GpsInfoSaved gpsInfoSaved = new GpsInfoSaved(destination);
            gpsInfoSaved.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
