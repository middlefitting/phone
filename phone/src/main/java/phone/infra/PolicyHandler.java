package phone.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phone.config.kafka.KafkaProcessor;
import phone.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    PhoneRepository phoneRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ImeiLocked'"
    )
    public void wheneverImeiLocked_StatusUpdate(
        @Payload ImeiLocked imeiLocked
    ) {
        ImeiLocked event = imeiLocked;
        System.out.println(
            "\n\n##### listener StatusUpdate : " + imeiLocked + "\n\n"
        );

        // Sample Logic //
        Phone.statusUpdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Locked'"
    )
    public void wheneverLocked_StatusUpdate(@Payload Locked locked) {
        Locked event = locked;
        System.out.println(
            "\n\n##### listener StatusUpdate : " + locked + "\n\n"
        );

        // Sample Logic //
        Phone.statusUpdate(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostCancelRequested'"
    )
    public void wheneverLostCancelRequested_StatusUpdate(
        @Payload LostCancelRequested lostCancelRequested
    ) {
        LostCancelRequested event = lostCancelRequested;
        System.out.println(
            "\n\n##### listener StatusUpdate : " + lostCancelRequested + "\n\n"
        );

        // Sample Logic //
        Phone.statusUpdate(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
