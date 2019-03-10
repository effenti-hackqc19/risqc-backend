package ca.effenti.risqc.core;

public interface RiskEvaluator {
    public static final Float MAX_RISK = 1F;
    public static final Float MIN_RISK = 0.1F;
    /*
    Distances are considered in kilometer
     */
    public Float computeRisk();


}
