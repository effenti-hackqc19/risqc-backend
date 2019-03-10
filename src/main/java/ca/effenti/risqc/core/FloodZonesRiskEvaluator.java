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
    public RiskMeaning computeRisk() {
        Float closestDistance = closestZone.getDistance();
        if (closestDistance == 0) {
            Float riskValue =  MAX_RISK * score/100;
            String message = "Vous êtes dans une zone à risque d'innondation";
            return  new RiskMeaning(message, riskValue);
        }
        if (closestDistance >= MIN_DISTANCE_TO_CONSIDER) {
            Float riskValue =   MIN_RISK * score/100;
            String message = "Vous êtes nêtes pas dans une zone à risque d'innondation";
            return  new RiskMeaning(message, riskValue);
        }
        Float riskValue =  score * getRiskFactor();
        String message = "Vous êtes à "+ closestDistance + "d'une zone à risque d'innondation";
        return  new RiskMeaning(message, riskValue);
    }

    private Float getRiskFactor() {
        Float closestDist = closestZone.getDistance();
        return 1 - closestDist / MIN_DISTANCE_TO_CONSIDER;
    }
}
