package ca.effenti.risqc.core;

import ca.effenti.risqc.model.ZoneRisqc;

public class FloodZonesRiskEvaluator implements RiskEvaluator {
    private static final Float MIN_DISTANCE_TO_CONSIDER = 1F;

    private final ZoneRisqc closestZone;
    private final Long score;

    FloodZonesRiskEvaluator(ZoneRisqc closestZone, Long score) {
        this.closestZone = closestZone;
        this.score = score;
    }

    @Override
    public Float computeRisk() {
        Float closestDistance = closestZone.getDistance();
        System.out.println("flood closest distance " + closestDistance);
        if (closestDistance == 0) {
            return MAX_RISK;
        }
        if (closestDistance >= MIN_DISTANCE_TO_CONSIDER) {
            return MIN_RISK;
        }
        return score * getRiskFactor();
    }

    private Float getRiskFactor() {
        Float closestDist = closestZone.getDistance();
        return 1 - closestDist / MIN_DISTANCE_TO_CONSIDER;
    }
}