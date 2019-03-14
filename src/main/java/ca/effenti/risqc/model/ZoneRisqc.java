package ca.effenti.risqc.model;


import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;

import static ca.effenti.risqc.core.RiskEvaluator.SPATIAL_DISTANCE_FACTOR_METERS;

@Entity
@Table(name = "flood_zone")
public class ZoneRisqc {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String type;

    private Geometry geometry;
    private Float distance;

    public ZoneRisqc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Float getDistance() {
        return distance * SPATIAL_DISTANCE_FACTOR_METERS;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
