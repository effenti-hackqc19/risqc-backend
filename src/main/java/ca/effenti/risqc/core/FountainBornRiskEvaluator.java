package ca.effenti.risqc.core;

import ca.effenti.risqc.model.FountainBorn;

public class FountainBornRiskEvaluator implements RiskEvaluator {
    private static final Float MAX_DISTANCE_TO_CONSIDER = 1F;

    private final FountainBorn closestFountainBorn;
    private final Long score;

    FountainBornRiskEvaluator(FountainBorn fountainBorn, Long score) {
        this.closestFountainBorn = fountainBorn;
        this.score = score;
    }


    @Override
    public Float computeRisk() {
        Float closestDistance = closestFountainBorn.getDistance();
        if (closestDistance == 0) {
            return MIN_RISK;
        }
        if (closestDistance >= MAX_DISTANCE_TO_CONSIDER) {
            return MAX_RISK;
        }
        return score * getRiskFactor();
    }

    private Float getRiskFactor() {
        return  closestFountainBorn.getDistance() / MAX_DISTANCE_TO_CONSIDER;
    }
}
