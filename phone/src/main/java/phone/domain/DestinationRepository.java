package phone.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import phone.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "destinations",
    path = "destinations"
)
public interface DestinationRepository
    extends PagingAndSortingRepository<Destination, Long> {
    @Query(
        value = "select destination " +
        "from Destination destination " +
        "where(:id is null or destination.id = :id) and (:time is null or destination.time = :time) and (:x is null or destination.x like %:x%) and (:y is null or destination.y like %:y%)"
    )
    Destination gpsInfoList(Long id, Date time, String x, String y);
}
