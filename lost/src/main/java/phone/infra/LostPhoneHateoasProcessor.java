package phone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phone.domain.*;

@Component
public class LostPhoneHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LostPhone>> {

    @Override
    public EntityModel<LostPhone> process(EntityModel<LostPhone> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/lock")
                .withRel("lock")
        );

        return model;
    }
}
