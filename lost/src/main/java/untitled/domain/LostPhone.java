package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.LostApplication;
import untitled.domain.ImeiLocked;
import untitled.domain.Locked;
import untitled.domain.LostAccessed;
import untitled.domain.LostCancelAccessed;
import untitled.domain.LostCancelRequested;
import untitled.domain.LostReportRequested;

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

        LostAccessed lostAccessed = new LostAccessed(this);
        lostAccessed.publishAfterCommit();

        ImeiLocked imeiLocked = new ImeiLocked(this);
        imeiLocked.publishAfterCommit();

        LostCancelRequested lostCancelRequested = new LostCancelRequested(this);
        lostCancelRequested.publishAfterCommit();

        LostCancelAccessed lostCancelAccessed = new LostCancelAccessed(this);
        lostCancelAccessed.publishAfterCommit();

        Locked locked = new Locked(this);
        locked.publishAfterCommit();
    }

    public static LostPhoneRepository repository() {
        LostPhoneRepository lostPhoneRepository = LostApplication.applicationContext.getBean(
            LostPhoneRepository.class
        );
        return lostPhoneRepository;
    }
}
//>>> DDD / Aggregate Root
