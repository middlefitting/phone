package phone.external;

import java.util.Date;
import lombok.Data;

@Data
public class PhoneInfoListQuery {

    private Long id;
    private Long userId;
    private String status;
    private String imei;
}
