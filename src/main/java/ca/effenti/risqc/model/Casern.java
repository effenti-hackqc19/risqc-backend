package ca.effenti.risqc.model;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.util.Objects;

import static ca.effenti.risqc.core.RiskEvaluator.SPATIAL_DISTANCE_FACTOR_METERS;

@Entity
@Table(name = "caserne")
public class Casern {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Point positionPont;

    private String noCivique;
    private String description;
    private String nomTopographie;
    private String rue;

    public Float getDistance() {
        return distance * SPATIAL_DISTANCE_FACTOR_METERS;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    private Float distance;


    public Casern() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPositionPont() {
        return positionPont;
    }

    public void setPositionPont(Point positionPont) {
        this.positionPont = positionPont;
    }

    public String getNoCivique() {
        return noCivique;
    }

    public void setNoCivique(String noCivique) {
        this.noCivique = noCivique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomTopographie() {
        return nomTopographie;
    }

    public void setNomTopographie(String nomTopographie) {
        this.nomTopographie = nomTopographie;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Casern)) return false;
        Casern casern = (Casern) o;
        return Objects.equals(getId(), casern.getId()) &&
                Objects.equals(getPositionPont(), casern.getPositionPont()) &&
                Objects.equals(getNoCivique(), casern.getNoCivique()) &&
                Objects.equals(getDescription(), casern.getDescription()) &&
                Objects.equals(getNomTopographie(), casern.getNomTopographie()) &&
                Objects.equals(getRue(), casern.getRue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPositionPont(), getNoCivique(), getDescription(), getNomTopographie(), getRue());
    }
}
