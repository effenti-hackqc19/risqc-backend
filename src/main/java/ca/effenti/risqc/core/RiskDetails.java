package ca.effenti.risqc.core;

import java.util.Objects;

public class RiskDetails {
    public RiskDetails() {}

    private RiskMeaning casernRisk;
    private RiskMeaning bornRisks;
    private RiskMeaning floodRisks;

    public RiskMeaning getCasernRisk() {
        return casernRisk;
    }

    public void setCasernRisk(RiskMeaning casernRisk) {
        this.casernRisk = casernRisk;
    }

    public RiskMeaning getBornRisks() {
        return bornRisks;
    }

    public void setBornRisks(RiskMeaning bornRisks) {
        this.bornRisks = bornRisks;
    }

    public RiskMeaning getFloodRisks() {
        return floodRisks;
    }

    public void setFloodRisks(RiskMeaning floodRisks) {
        this.floodRisks = floodRisks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RiskDetails)) return false;
        RiskDetails that = (RiskDetails) o;
        return Objects.equals(getCasernRisk(), that.getCasernRisk()) &&
                Objects.equals(getBornRisks(), that.getBornRisks()) &&
                Objects.equals(getFloodRisks(), that.getFloodRisks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCasernRisk(), getBornRisks(), getFloodRisks());
    }
}

class RiskMeaning {
    public RiskMeaning() {}
    public String message;
    public Float value;

    public RiskMeaning(String message, Float value) {
        this.message = message;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RiskMeaning)) return false;
        RiskMeaning that = (RiskMeaning) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, value);
    }
}
