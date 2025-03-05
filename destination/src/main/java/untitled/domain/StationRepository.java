package untitled.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "stations", path = "stations")
public interface StationRepository
    extends PagingAndSortingRepository<Station, Long> {
    @Query(
        value = "select station " +
        "from Station station " +
        "where(:id is null or station.id = :id) and (:name is null or station.name like %:name%) and (:date is null or station.date = :date) and (:x is null or station.x like %:x%) and (:y is null or station.y like %:y%)"
    )
    Station stationInfoList(
        Long id,
        String name,
        Date date,
        String x,
        String y
    );
}
