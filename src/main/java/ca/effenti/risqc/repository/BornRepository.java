package ca.effenti.risqc.repository;

import ca.effenti.risqc.model.FountainBorn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BornRepository extends CrudRepository<FountainBorn, Long> {
    @Query(value = "SELECT *, ST_Distance(ST_GeomFromText(CONCAT('POINT(', :longitude , ' ', :latitude , ')')), location) as distance " +
            "FROM fountain_born ORDER BY distance LIMIT 100;", nativeQuery = true)
    public List<FountainBorn> findClosestFountainBorns (
            @Param(value = "longitude") Double longitude,
            @Param(value="latitude") Double latitude);
}
