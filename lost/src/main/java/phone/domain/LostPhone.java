package phone.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import phone.LostApplication;
import phone.domain.LostCancelRequested;
import phone.domain.LostReportRequested;

@Entity
@Table(name = "LostPhone_table")
@Data
//<<< DDD / Aggregate Root
public class LostPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String imei;

    private String lostStatus;

    private String imeiStatus;

    private String lockStatus;

    private Long phoneId;

    @PostPersist
    public void onPostPersist() {
        LostReportRequested lostReportRequested = new LostReportRequested(this);
        lostReportRequested.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        LostCancelRequested lostCancelRequested = new LostCancelRequested(this);
        lostCancelRequested.publishAfterCommit();
    }

    public static LostPhoneRepository repository() {
        LostPhoneRepository lostPhoneRepository = LostApplication.applicationContext.getBean(
            LostPhoneRepository.class
        );
        return lostPhoneRepository;
    }

    //<<< Clean Arch / Port Method
    public void lock() {
        //implement business logic here:

        Locked locked = new Locked(this);
        locked.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
