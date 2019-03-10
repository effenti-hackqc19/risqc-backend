package ca.effenti.risqc.model;

import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;

@Entity
@Table(name = "zonerisqc")
public class ZoneRisqc {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Geometry geometry;

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
}
