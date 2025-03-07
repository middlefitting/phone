package phone.domain;

import phone.domain.GpsInfoSaved;
import phone.PhoneApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Destination_table")
@Data

//<<< DDD / Aggregate Root
public class Destination  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private Date time;
    
    
    
    
    private String x;
    
    
    
    
    private String y;
    
    
    
    
    private Long phoneId;

    @PostPersist
    public void onPostPersist(){
    Phone phone = DestinationApplication.applicationContext
        .getBean(phone.external.PhoneService.class)
        .phoneInfoList(get??);


        GpsInfoSaved gpsInfoSaved = new GpsInfoSaved(this);
        gpsInfoSaved.publishAfterCommit();

    
    }

    public static DestinationRepository repository(){
        DestinationRepository destinationRepository = PhoneApplication.applicationContext.getBean(DestinationRepository.class);
        return destinationRepository;
    }






}
//>>> DDD / Aggregate Root
