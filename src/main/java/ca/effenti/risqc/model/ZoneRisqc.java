package ca.effenti.risqc.model;


import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;

@Entity
@Table(name = "flood_zone")
public class ZoneRisqc {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Geometry geometry;
    private Double distance;

    public ZoneRisqc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
