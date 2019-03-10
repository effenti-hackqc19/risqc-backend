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
    public RiskMeaning computeRisk() {
        Float closestDistance = closestFountainBorn.getDistance();
        if (closestDistance == 0) {
            Float riskValue =  MIN_RISK * score/100;
            String message = "Vous êtes à une bonne distance d'une borne d'incendie";
            return  new RiskMeaning(message, riskValue);
        }
        if (closestDistance >= MAX_DISTANCE_TO_CONSIDER) {
            Float riskValue =   MAX_RISK*score/100;
            String message = "Vous êtes loin d'une borne d'incendie";
            return  new RiskMeaning(message, riskValue);
        }
        Float riskValue =  score * getRiskFactor();
        String message = "Vous êtes à "+ closestDistance + "d'une borne d'incendie";
        return  new RiskMeaning(message, riskValue);
    }

    private Float getRiskFactor() {
        return  closestFountainBorn.getDistance() / MAX_DISTANCE_TO_CONSIDER;
    }
}
