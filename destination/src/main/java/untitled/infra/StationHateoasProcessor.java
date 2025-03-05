package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class StationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Station>> {

    @Override
    public EntityModel<Station> process(EntityModel<Station> model) {
        return model;
    }
}
