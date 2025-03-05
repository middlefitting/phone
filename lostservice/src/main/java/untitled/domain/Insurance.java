package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.LostserviceApplication;
import untitled.domain.InsuranceAccessed;
import untitled.domain.InsuranceCanceled;
import untitled.domain.InsuranceRequested;

@Entity
@Table(name = "Insurance_table")
@Data
//<<< DDD / Aggregate Root
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long lostPhoneId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        InsuranceAccessed insuranceAccessed = new InsuranceAccessed(this);
        insuranceAccessed.publishAfterCommit();

        InsuranceCanceled insuranceCanceled = new InsuranceCanceled(this);
        insuranceCanceled.publishAfterCommit();

        InsuranceRequested insuranceRequested = new InsuranceRequested(this);
        insuranceRequested.publishAfterCommit();
    }

    public static InsuranceRepository repository() {
        InsuranceRepository insuranceRepository = LostserviceApplication.applicationContext.getBean(
            InsuranceRepository.class
        );
        return insuranceRepository;
    }

    //<<< Clean Arch / Port Method
    public static void reportCancel(LostCancelAccessed lostCancelAccessed) {
        //implement business logic here:

        /** Example 1:  new item 
        Insurance insurance = new Insurance();
        repository().save(insurance);

        InsuranceCanceled insuranceCanceled = new InsuranceCanceled(insurance);
        insuranceCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostCancelAccessed.get???()).ifPresent(insurance->{
            
            insurance // do something
            repository().save(insurance);

            InsuranceCanceled insuranceCanceled = new InsuranceCanceled(insurance);
            insuranceCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
