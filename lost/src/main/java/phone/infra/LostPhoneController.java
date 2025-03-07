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
// @RequestMapping(value="/lostPhones")
@Transactional
public class LostPhoneController {

    @Autowired
    LostPhoneRepository lostPhoneRepository;

    @RequestMapping(
        value = "/lostPhones/{id}/lock",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public LostPhone lock(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lostPhone/lock  called #####");
        Optional<LostPhone> optionalLostPhone = lostPhoneRepository.findById(
            id
        );

        optionalLostPhone.orElseThrow(() -> new Exception("No Entity Found"));
        LostPhone lostPhone = optionalLostPhone.get();
        lostPhone.lock();

        lostPhoneRepository.save(lostPhone);
        return lostPhone;
    }
}
//>>> Clean Arch / Inbound Adaptor
