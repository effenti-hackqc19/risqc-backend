package ca.effenti.risqc.repository;

import ca.effenti.risqc.model.ZoneRisqc;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ZoneRisqcRepository  extends CrudRepository<ZoneRisqc, Integer> {
    @Query(value = "SELECT id, type, IF(geozone IS NULL, \n" +
            "ST_Distance(ST_GeomFromText(CONCAT('POINT(', :longitude , ' ', :latitude , ')')), multi_geozone), \n" +
            "ST_Distance(ST_GeomFromText(CONCAT('POINT(', :longitude , ' ', :latitude , ')')), geozone)\n" +
            ") as distance,\n" +
            "IFNULL(geozone, multi_geozone) as geometry\n" +
            "FROM flood_zone\n" +
            "ORDER BY distance\n" +
            "LIMIT 25;", nativeQuery = true)
    List<ZoneRisqc> findClosestZones(
            @Param("longitude") Double longitude,
            @Param("latitude") Double latitude
    );
}
