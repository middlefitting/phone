package phone.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phone.config.kafka.KafkaProcessor;
import phone.domain.*;

@Service
public class PhoneViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private PhoneRepository phoneRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPhoneCreated_then_CREATE_1(
        @Payload PhoneCreated phoneCreated
    ) {
        try {
            if (!phoneCreated.validate()) return;

            // view 객체 생성
            Phone phone = new Phone();
            // view 객체에 이벤트의 Value 를 set 함
            phone.setId(phoneCreated.getId());
            phone.setUserId(phoneCreated.getUserId());
            phone.setImei(Long.valueOf(phoneCreated.getImei()));
            // view 레파지 토리에 save
            phoneRepository.save(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPhoneDeleted_then_CREATE_2(
        @Payload PhoneDeleted phoneDeleted
    ) {
        try {
            if (!phoneDeleted.validate()) return;

            // view 객체 생성
            Phone phone = new Phone();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            phoneRepository.save(phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPhoneDeleted_then_DELETE_1(
        @Payload PhoneDeleted phoneDeleted
    ) {
        try {
            if (!phoneDeleted.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            phoneRepository.deleteById(phoneDeleted.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
