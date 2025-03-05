package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class DestinationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Destination>> {

    @Override
    public EntityModel<Destination> process(EntityModel<Destination> model) {
        return model;
    }
}
