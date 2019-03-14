package ca.effenti.risqc.repository;

import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CasernRepository extends CrudRepository<Casern, Long> {
    @Query(value = "SELECT *, ST_Distance(ST_GeomFromText(CONCAT('POINT(', :longitude , ' ', :latitude , ')')), position_pont) as distance " +
            "FROM caserne ORDER BY distance LIMIT 3;", nativeQuery = true)
    public List<Casern> findClosestCasern(
            @Param(value = "longitude") Double longitude,
            @Param(value = "latitude") Double latitude);
}
