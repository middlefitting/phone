package phone.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phone.domain.*;

@Component
public class InsuranceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Insurance>> {

    @Override
    public EntityModel<Insurance> process(EntityModel<Insurance> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/insuranceaccessrequest"
                )
                .withRel("insuranceaccessrequest")
        );

        return model;
    }
}
