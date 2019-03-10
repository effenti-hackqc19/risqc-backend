package ca.effenti.risqc.model;

import org.springframework.data.geo.Point;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Born {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Point point;


    public Born() {
    }

    public Born(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Born)) return false;
        Born born = (Born) o;
        return Objects.equals(getPoint(), born.getPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint());
    }
}
