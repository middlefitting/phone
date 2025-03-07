package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.LostserviceApplication;
import phone.domain.InsuranceCanceled;
import phone.domain.InsuranceRequested;

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

    public static InsuranceRepository repository() {
        InsuranceRepository insuranceRepository = LostserviceApplication.applicationContext.getBean(
            InsuranceRepository.class
        );
        return insuranceRepository;
    }

    //<<< Clean Arch / Port Method
    public void insuranceAccessRequest() {
        //implement business logic here:

        InsuranceAccessed insuranceAccessed = new InsuranceAccessed(this);
        insuranceAccessed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void reportCancel(LostCancelRequested lostCancelRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Insurance insurance = new Insurance();
        repository().save(insurance);

        InsuranceCanceled insuranceCanceled = new InsuranceCanceled(insurance);
        insuranceCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostCancelRequested.get???()).ifPresent(insurance->{
            
            insurance // do something
            repository().save(insurance);

            InsuranceCanceled insuranceCanceled = new InsuranceCanceled(insurance);
            insuranceCanceled.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void insuranceRequest(
        LostReportRequested lostReportRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Insurance insurance = new Insurance();
        repository().save(insurance);

        InsuranceRequested insuranceRequested = new InsuranceRequested(insurance);
        insuranceRequested.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(lostReportRequested.get???()).ifPresent(insurance->{
            
            insurance // do something
            repository().save(insurance);

            InsuranceRequested insuranceRequested = new InsuranceRequested(insurance);
            insuranceRequested.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
