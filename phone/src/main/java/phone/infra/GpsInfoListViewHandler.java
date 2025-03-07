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
public class GpsInfoListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private GpsInfoListRepository gpsInfoListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenGpsInfoSaved_then_CREATE_1(
        @Payload GpsInfoSaved gpsInfoSaved
    ) {
        try {
            if (!gpsInfoSaved.validate()) return;

            // view 객체 생성
            GpsInfoList gpsInfoList = new GpsInfoList();
            // view 객체에 이벤트의 Value 를 set 함
            gpsInfoList.setId(gpsInfoSaved.getId());
            gpsInfoList.setTime(gpsInfoSaved.getTime());
            gpsInfoList.setX(gpsInfoSaved.getX());
            gpsInfoList.setY(gpsInfoSaved.getY());
            gpsInfoList.setPhoneId(gpsInfoSaved.getPhoneId());
            // view 레파지 토리에 save
            gpsInfoListRepository.save(gpsInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
