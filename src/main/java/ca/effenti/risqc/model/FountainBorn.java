package ca.effenti.risqc.model;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fountain_born")
public class FountainBorn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Point location;

    private String ville;
    private String arrondissement;
    private String nomTopo;
    private Double distance;


    public FountainBorn() {
    }

    public FountainBorn(Point point) {
        this.location = point;
    }

    public Point getPoint() {
        return location;
    }

    public void setPoint(Point point) {
        this.location = point;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getNomTopo() {
        return nomTopo;
    }

    public void setNomTopo(String nomTopo) {
        this.nomTopo = nomTopo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FountainBorn)) return false;
        FountainBorn fountainBorn = (FountainBorn) o;
        return Objects.equals(getPoint(), fountainBorn.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint());
    }
}
