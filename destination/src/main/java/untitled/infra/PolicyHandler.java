package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    DestinationRepository destinationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LogTransfered'"
    )
    public void wheneverLogTransfered_StationChange(
        @Payload LogTransfered logTransfered
    ) {
        LogTransfered event = logTransfered;
        System.out.println(
            "\n\n##### listener StationChange : " + logTransfered + "\n\n"
        );

        // Sample Logic //
        Station.stationChange(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LogTransfered'"
    )
    public void wheneverLogTransfered_SendGpsInfo(
        @Payload LogTransfered logTransfered
    ) {
        LogTransfered event = logTransfered;
        System.out.println(
            "\n\n##### listener SendGpsInfo : " + logTransfered + "\n\n"
        );

        // Sample Logic //
        Destination.sendGpsInfo(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
