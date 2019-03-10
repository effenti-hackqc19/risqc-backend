package ca.effenti.risqc.core;

public interface RiskEvaluator {
    public static final Float MAX_RISK = 90F;
    public static final Float MIN_RISK = 10F;

    public static final Float SPATIAL_DISTANCE_FACTOR_METERS = 111.195F;
    /*
    Distances are considered in kilometer
     */
    public RiskMeaning computeRisk();


}
