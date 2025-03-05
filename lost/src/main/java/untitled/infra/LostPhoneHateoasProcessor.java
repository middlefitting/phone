package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class LostPhoneHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LostPhone>> {

    @Override
    public EntityModel<LostPhone> process(EntityModel<LostPhone> model) {
        return model;
    }
}
