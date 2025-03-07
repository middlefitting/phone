package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.PhoneApplication;
import phone.domain.PhoneStatusUpdated;

@Entity
@Table(name = "Phone_table")
@Data
//<<< DDD / Aggregate Root
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String status;

    private String imei;

    public static PhoneRepository repository() {
        PhoneRepository phoneRepository = PhoneApplication.applicationContext.getBean(
            PhoneRepository.class
        );
        return phoneRepository;
    }

    //<<< Clean Arch / Port Method
    public static void statusUpdate(ImeiLocked imeiLocked) {
        //implement business logic here:

        /** Example 1:  new item 
        Phone phone = new Phone();
        repository().save(phone);

        PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
        phoneStatusUpdated.publishAfterCommit();
        PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
        phoneStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(imeiLocked.get???()).ifPresent(phone->{
            
            phone // do something
            repository().save(phone);

            PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
            phoneStatusUpdated.publishAfterCommit();
            PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
            phoneStatusUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void statusUpdate(Locked locked) {
        //implement business logic here:

        /** Example 1:  new item 
        Phone phone = new Phone();
        repository().save(phone);

        PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
        phoneStatusUpdated.publishAfterCommit();
        PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
        phoneStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(locked.get???()).ifPresent(phone->{
            
            phone // do something
            repository().save(phone);

            PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
            phoneStatusUpdated.publishAfterCommit();
            PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
            phoneStatusUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void statusUpdate(LostCancelRequested lostCancelRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Phone phone = new Phone();
        repository().save(phone);

        PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
        phoneStatusUpdated.publishAfterCommit();
        PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
        phoneStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostCancelRequested.get???()).ifPresent(phone->{
            
            phone // do something
            repository().save(phone);

            PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
            phoneStatusUpdated.publishAfterCommit();
            PhoneStatusUpdated phoneStatusUpdated = new PhoneStatusUpdated(phone);
            phoneStatusUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
