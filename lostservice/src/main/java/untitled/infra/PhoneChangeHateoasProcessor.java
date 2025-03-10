package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class PhoneChangeHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PhoneChange>> {

    @Override
    public EntityModel<PhoneChange> process(EntityModel<PhoneChange> model) {
        return model;
    }
}
