package phone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import phone.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/insurances")
@Transactional
public class InsuranceController {

    @Autowired
    InsuranceRepository insuranceRepository;

    @RequestMapping(
        value = "/insurances/{id}/insuranceaccessrequest",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Insurance insuranceAccessRequest(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /insurance/insuranceAccessRequest  called #####"
        );
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(
            id
        );

        optionalInsurance.orElseThrow(() -> new Exception("No Entity Found"));
        Insurance insurance = optionalInsurance.get();
        insurance.insuranceAccessRequest();

        insuranceRepository.save(insurance);
        return insurance;
    }
}
//>>> Clean Arch / Inbound Adaptor
