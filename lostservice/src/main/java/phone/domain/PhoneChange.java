package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.LostserviceApplication;
import phone.domain.PhoneChangeCanceled;
import phone.domain.PhoneChangeRequested;

@Entity
@Table(name = "PhoneChange_table")
@Data
//<<< DDD / Aggregate Root
public class PhoneChange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long lostPhoneId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PhoneChangeRequested phoneChangeRequested = new PhoneChangeRequested(
            this
        );
        phoneChangeRequested.publishAfterCommit();
    }

    public static PhoneChangeRepository repository() {
        PhoneChangeRepository phoneChangeRepository = LostserviceApplication.applicationContext.getBean(
            PhoneChangeRepository.class
        );
        return phoneChangeRepository;
    }

    //<<< Clean Arch / Port Method
    public static void reportCancel(LostCancelRequested lostCancelRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        PhoneChange phoneChange = new PhoneChange();
        repository().save(phoneChange);

        PhoneChangeCanceled phoneChangeCanceled = new PhoneChangeCanceled(phoneChange);
        phoneChangeCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostCancelRequested.get???()).ifPresent(phoneChange->{
            
            phoneChange // do something
            repository().save(phoneChange);

            PhoneChangeCanceled phoneChangeCanceled = new PhoneChangeCanceled(phoneChange);
            phoneChangeCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
