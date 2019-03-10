package ca.effenti.risqc.core;

import ca.effenti.risqc.model.Casern;
import ca.effenti.risqc.model.FountainBorn;

public class CasernRiskEvaluator implements RiskEvaluator {
    private static final Float MAX_DISTANCE_TO_CONSIDER = 1F;

    private final Casern closestCasern;
    private final Long score;

    CasernRiskEvaluator(Casern casern, Long score) {
        this.closestCasern = casern;
        this.score = score;
    }


    @Override
    public Float computeRisk() {
        Float closestDistance = closestCasern.getDistance();
        if (closestDistance == 0) {
            return MIN_RISK*score/100;
        }
        if (closestDistance >= MAX_DISTANCE_TO_CONSIDER) {
            return MAX_RISK * score/100;
        }
        return score * getRiskFactor();
    }

    private Float getRiskFactor() {
        return  closestCasern.getDistance() / MAX_DISTANCE_TO_CONSIDER;
    }
}
