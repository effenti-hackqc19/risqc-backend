package ca.effenti.risqc.service;

import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.model.ZoneRisqc;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RisqcResponse {
    public RisqcResponse() {}

    private List<ZoneRisqc> zones = new ArrayList<>();

    private List<FountainBorn> borns = new ArrayList<>();

    public List<ZoneRisqc> getZones() {
        return zones;
    }

    public void setZones(List<ZoneRisqc> zones) {
        this.zones = zones;
    }

    public List<FountainBorn> getBorns() {
        return borns;
    }

    public void setBorns(List<FountainBorn> borns) {
        this.borns = borns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RisqcResponse)) return false;
        RisqcResponse that = (RisqcResponse) o;
        return getZones().equals(that.getZones()) &&
                getBorns().equals(that.getBorns());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZones(), getBorns());
    }
}
