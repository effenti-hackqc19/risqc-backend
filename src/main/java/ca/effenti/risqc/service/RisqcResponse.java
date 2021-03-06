package ca.effenti.risqc.service;

import ca.effenti.risqc.core.RiskDetails;
import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;
import ca.effenti.risqc.model.ZoneRisqc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RisqcResponse {
    public RisqcResponse() {}

    private List<ZoneRisqc> zones = new ArrayList<>();

    private List<FountainBorn> borns = new ArrayList<>();

    private Float riskScore = 0F;

    private RiskDetails riskDetails;

    public RiskDetails getRiskDetails() {
        return riskDetails;
    }

    public void setRiskDetails(RiskDetails riskDetails) {
        this.riskDetails = riskDetails;
    }

    private List<Casern> caserns= new ArrayList<>();

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

    public Float getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Float riskScore) {
        this.riskScore = riskScore;
    }

    public List<Casern> getCaserns() {
        return caserns;
    }

    public void setCaserns(List<Casern> caserns) {
        this.caserns = caserns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RisqcResponse)) return false;
        RisqcResponse that = (RisqcResponse) o;
        return getZones().equals(that.getZones()) &&
                getBorns().equals(that.getBorns()) &&
                getCaserns().equals(that.getCaserns());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getZones(), getBorns(), getCaserns());
    }
}
