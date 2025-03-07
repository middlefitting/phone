package phone.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phone.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "phones", path = "phones")
public interface PhoneRepository
    extends PagingAndSortingRepository<Phone, Long> {
    @Query(
        value = "select phone " +
        "from Phone phone " +
        "where(:id is null or phone.id = :id) and (:userId is null or phone.userId = :userId) and (:status is null or phone.status like %:status%) and (:imei is null or phone.imei like %:imei%)"
    )
    Phone phoneInfoList(Long id, Long userId, String status, String imei);
}
